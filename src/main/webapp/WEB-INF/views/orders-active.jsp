<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container bg-grayLighter">

  <div class="tile-container padding40 no-padding-bottom">
    <a class="tile bg-cyan bg-active-darkBlue fg-white margin20 padding10" href="../../servers/orders/new">
      <div class="tile-content iconic">
        <span class="icon mif-spoon-fork"></span>
      </div>
      <span class="tile-label">New Order</span>
    </a>
    <c:forEach items="${dishes}" var="dish">
      <c:if test="${dish.hasMissingIngredient() || dish.getNumberPossibleDishes() == 0}">
      <a class="tile bg-darkOrange bg-active-orange fg-white margin20 padding10" href="manager/dishes/${dish.getId()}">
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
        	<a class="tile-wide bg-emerald big-active-green fg-white margin20 padding10" href="servers/orders/${order.getId()}">
       </c:when>
       <c:when test="${order.isUp()}">
        	<a class="tile-wide bg-darkCobalt big-active-blue fg-white margin20 padding10" href="servers/orders/${order.getId()}">
     	</c:when>
        <c:otherwise>
        	<a class="tile-wide bg-crimson big-active-red fg-white margin20 padding10" href="servers/orders/${order.getId()}">
    	</c:otherwise>
      </c:choose>
      
          <div class="tile-content iconic slide-right">
           <c:choose>
            <c:when test="${order.checkPaid()}">
              <div class="slide">
                <span class="icon mif-dollar2"></span>
              </div>
              <div class="slide-over op-green padding-20 text-accent align-center">
             </c:when>
            <c:when test="${order.isUp()}">
              <div class="slide">
                <span class="icon mif-arrow-up"></span>
              </div>
              <div class="slide-over op-blue padding-20 text-accent align-center">
             </c:when>
             <c:otherwise>
              <div class="slide">
                <span class="icon mif-fire"></span>
              </div>
              <div class="slide-over op-red padding-20 text-accent align-center">
             </c:otherwise>
            </c:choose>
                <p>
                  ${order.getDishName()}<br>
                  ${order.getCreationTime().substring(0, 5)}<br>
                  <c:if test="${not empty order.getComments()}">
                    ${order.getComments()}
                  </c:if>
                </p>
              </div>
          </div>   <!--tile content -->
          <div class="tile-label">
            Table: ${order.getTable()} | Seat: ${order.getSeat()}
          </div>
        </a>
    </c:forEach>
  </div>
</div>



<jsp:include page="footer.jsp"></jsp:include>