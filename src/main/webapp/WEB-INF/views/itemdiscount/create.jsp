<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/webresources/common/header.jspf"%>

<div id="wrapper">
    <%@ include file="/webresources/common/navigationbar.jspf"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h5><i class="fa fa-plus-square fa-fw"></i> <b> Create a new Itemdiscount </b></h5>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" action="${appPath}/itemdiscount/new" method="POST">
                                    <div class="form-group">
                                        <label for="IDid">iDid</label>
                                        <input class="form-control" type="number" name="iDid" path="iDid"  required="required" autofocus="autofocus"  />
                                    </div>
                                    <div class="form-group">
                                        <label>Item</label>
                                        <select path="item1" name="item1" onchange=" ">
                                            <option value="ord_null">Нет</option>
                                            <c:forEach items="${ITEM_LIST}" var="ITEM">
                                                <option value="${ITEM.itemId}">${ITEM.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Discountrule</label>
                                        <select path="discountrule1" name="discountrule1" onchange=" ">
                                            <option value="ord_null">Нет</option>
                                            <c:forEach items="${DISCOUNTRULE_LIST}" var="DISCOUNTRULE">
                                                <option value="${DISCOUNTRULE.dRId}">${DISCOUNTRULE.discountValue}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-check fa-fw"></i>Submit</button>
                                    <a href="${appPath}/itemdiscount/list" class="btn btn-default"><i class="fa fa-close fa-fw"></i>Cancel</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="/webresources/common/footer.jspf"%>
