/**
 * 导出链接信息
 */
function exportLinkInfo() {
    window.location.href="/personal/linkInfo/exportLinkInfo"
}

/**
 * 重置链接信息
 */
function resetLinkInfoModel() {
    $("input[name='name']").val('');
    $("input[name='url']").val('');
    $("#updLinkCategoryId option:first").prop("selected", 'selected');
    $("#linkCategoryId option:first").prop("selected", 'selected');
    $("#updStatus option:first").prop("selected", 'selected');
    $("#status option:first").prop("selected", 'selected');
    $("input[name='sortNo']").val('');
    $("input[name='linkId']").val('');
}

/**
 * 显示链接信息
 * @param linkId
 * @param name
 * @param url
 * @param linkCategoryId
 * @param status
 * @param sortNo
 */
function showLinkInfo(linkId, name, url, linkCategoryId, status, sortNo) {
    resetLinkInfoModel();
    $("#updLinkId").val(linkId);
    $("#updName").val(name);
    $("#updUrl").val(url);
    $("#updLinkCategoryId").val(linkCategoryId);
    $("#updStatus").val(status);
    $("#updSortNo").val(sortNo);

    $("#updateLinkInfoModal").modal();
}


/**
 * 修改链接信息
 */
function updateLinkInfo() {
    var id = $("#updLinkId").val();
    var name = $("#updName").val();
    var url = $("#updUrl").val();
    var linkCategoryId = $("#updLinkCategoryId").val();
    var status = $("#updStatus").val();
    var sortNo = $("#updSortNo").val();

    $.post("/personal/linkInfo/modifyLinkInfo", {
        "id": id,
        "name": name,
        "url": url,
        "linkCategoryId": linkCategoryId,
        "status": status,
        "sortNo": sortNo
    }, function (resp) {
        if (resp.code == 200) {
            toastr.success(resp.data);
        } else {
            toastr.error(resp.data);
        }
    }, "json");

}


















