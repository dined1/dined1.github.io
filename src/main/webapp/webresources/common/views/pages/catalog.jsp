<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/webresources/common/header.jspf"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div id="wrapper">
    <%--<%@ include file="/webresources/common/navigationbar.jspf"%>--%>
    <div id="page-wrapper" style="min-height: 476px;">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5><i class="fa fa-plus-square fa-fw"></i> <b> Item catalog </b></h5>
                    </div>
                    <div class="panel-body">

                        <div class="container">
                            <ul class="nav nav-pills">
                                <li><a href="${contextPath}/adm/orderentry/basket/${CUSTOMERID}/${SOID}">Card<span id="total-cart-count" class="badge"></span></a></li>
                                <li class="active"><a href="${contextPath}/adm/orderentry/catalog/${CUSTOMERID}/${SOID}">Catalog</a></li>
                                <li><a href="${contextPath}/adm/orderentry/order/${CUSTOMERID}/${SOID}">Checkout</a></li>
                            </ul>
                            <br />
                        </div>

                        <table class="table table-striped table-bordered table-hover" id="ITEM_TABLE">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Product type</th>
                                <th>Description</th>
                                <th>Default One-time price, USD</th>
                                <th>Default Mounth price, USD</th>
                                <th>Modified Date</th>
                                <th>Available amount</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${ITEM_LIST}" var="ITEM">
                                <c:if test="${ITEM.item.quantity > 0}">
                                    <tr>
                                        <td class="bg-info"><a href="${contextPath}/adm/orderentry/itemdescription/${ITEM.item.itemId}/${CUSTOMERID}/${SOID}">${(ITEM.item.name)}</a></td>

                                        <td>${(ITEM.item.type)}</td>

                                        <td>${(ITEM.item.description)}</td>

                                        <td>${(ITEM.item.defOTP)}</td>

                                        <td>${(ITEM.item.defMP)}</td>

                                        <td>${(ITEM.item.modifiedDate)}</td>

                                        <td>${(ITEM.item.quantity)}</td>

                                        <td>
                                            <a href="${contextPath}/adm/orderentry/add/${ITEM.item.itemId}/${CUSTOMERID}/${SOID}"><i class="fa fa-level-up fa-fw"></i>Add</a>
                                        </td>

                                    </tr>
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>


                        <script src="${contextPath}/webresources/common/js/vendor/jquery.min.js" type="text/javascript"></script>
                        <script src="${contextPath}/webresources/common/js/vendor/underscore.min.js" type="text/javascript"></script>
                        <script src="${contextPath}/webresources/common/js/modules/catalog.js" type="text/javascript"></script>
                        <script src="${contextPath}/webresources/common/js/modules/cart.js" type="text/javascript"></script>
                        <script src="${contextPath}/webresources/common/js/modules/main.js" type="text/javascript"></script>
                        <a href="${contextPath}/adm/orderentry/${CUSTOMERID}" class="btn btn-default"><i class="fa fa-arrow-circle-left fa-fw"></i>Back</a>
                    </div>

                </div>
                <div id='gcw_mainFDKzQnAYv' class='gcw_mainFDKzQnAYv'></div>
                <a id='gcw_siteFDKzQnAYv' href='http://freecurrencyrates.com/ru/'>FreeCurrencyRates.com</a>
                <script>function reloadFDKzQnAYv(){ var sc = document.getElementById('scFDKzQnAYv');if (sc) sc.parentNode.removeChild(sc);sc = document.createElement('script');sc.type = 'text/javascript';sc.charset = 'UTF-8';sc.async = true;sc.id='scFDKzQnAYv';sc.src = 'http://freecurrencyrates.com/ru/widget-horizontal-editable?iso=USDEURBYNRUBCNY&df=1&p=FDKzQnAYv&v=fi&source=fcr&width=900&width_title=184&firstrowvalue=1&thm=A6C9E2,FCFDFD,4297D7,5C9CCC,FFFFFF,C5DBEC,FCFDFD,2E6E9E,000000&title=%D0%9A%D0%BE%D0%BD%D0%B2%D0%B5%D1%80%D1%82%D0%B5%D1%80%20%D0%B2%D0%B0%D0%BB%D1%8E%D1%82&tzo=-180';var div = document.getElementById('gcw_mainFDKzQnAYv');div.parentNode.insertBefore(sc, div);} reloadFDKzQnAYv(); </script>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){
        $('#ITEM_TABLE').dataTable();
    });
</script>
<%--end content--%>
<%@ include file="/webresources/common/footer.jspf"%>
