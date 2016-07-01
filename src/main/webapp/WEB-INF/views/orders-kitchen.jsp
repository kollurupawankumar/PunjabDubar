<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container bg-grayLighter">

  <div class="tile-container padding40 no-padding-bottom">
  <c:forEach items="${dishes}" var="dish">
     <c:if test="${dish.hasMissingIngredient() || dish.getNumberPossibleDishes() == 0 }">
           <a class="tile bg-darkOrange bg-active-orange fg-white margin20 padding10" href="/manager/dishes/$dish.getId()">
        <div class="tile-content iconic">
          <span class="icon mif-not"></span>
        </div>
        <span class="tile-label">86 ${dish.getName()}</span>
      </a>
       </c:if>
     </c:forEach>
  </div>

  <div class="tile-container padding40 no-padding-top">
  <c:forEach items="${orders}" var="order">
  <c:choose>
  	  <c:when test="${order.checkPaid()}">
        <a class="tile-wide bg-emerald big-active-green fg-white margin20 padding10" href="kitchen/orders/${order.getId()}">
      </a></c:when>
      <c:when test="${order.isUp()}">
        <a class="tile-wide bg-darkCobalt big-active-blue fg-white margin20 padding10" href="kitchen/orders/${order.getId()}">
      </a></c:when>
      <c:otherwise>
        <a class="tile-wide bg-crimson big-active-red fg-white margin20 padding10" href="kitchen/orders/${order.getId()}">
   	  </c:otherwise>
   </c:choose>
          <div class="tile-content iconic slide-right">
          <c:choose>
            <c:when test="${order.checkPaid()}">
              <div class="slide">
                <span class="icon mif-dollar2">
                <div class="slide-over op-red padding-20 text-accent align-center">
            
                <p>
                  <c:out value="${order.getDishName()}"></c:out><br>
                  <c:out value="${order.getCreationTime()}"></c:out>
                <!--   $order.getCreationTime().substring(0, 5)--> <br>
                  <c:if test="${order.getComments() != null }">
                  		<c:out value="${order.getComments()}"></c:out>
                  </c:if>
                </p>
              </div>
                </span>
              </div>
            </c:when>
            <c:when test="${order.isUp()}">
              <div class="slide-over op-green padding-20 text-accent align-center">
              <div class="slide">
                <span class="icon mif-arrow-up">
                <div class="slide-over op-red padding-20 text-accent align-center">
            
                <p>
                  <c:out value="${order.getDishName()}"></c:out><br>
                  <c:out value="${order.getCreationTime()}"></c:out>
                <!--   $order.getCreationTime().substring(0, 5)--> <br>
                  <c:if test="${order.getComments() != null }">
                  		<c:out value="${order.getComments()}"></c:out>
                  </c:if>
                </p>
              </div>
                </span>
              </div>
              </div>
             </c:when>
             <c:otherwise>
              <div class="slide-over op-blue padding-20 text-accent align-center">
              <div class="slide">
                <span class="icon mif-fire">
                <div class="slide-over op-red padding-20 text-accent align-center">
            
                <p>
                  <c:out value="${order.getDishName()}"></c:out><br>
                  <c:out value="${order.getCreationTime()}"></c:out>
                <!--   $order.getCreationTime().substring(0, 5)--> <br>
                  <c:if test="${order.getComments() != null }">
                  		<c:out value="${order.getComments()}"></c:out>
                  </c:if>
                </p>
              </div>
                </span>
              </div>
              </div>
            </c:otherwise>
            </c:choose>
          </div>   <!--tile content -->
          <div class="tile-label">
            Table: <c:out value="${order.getTable()}"></c:out> | Seat: <c:out value="${order.getSeat()}"></c:out>
          </div>
        
    </c:forEach>
  </div>
</div>




<jsp:include page="footer.jsp"></jsp:include>