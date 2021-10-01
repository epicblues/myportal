function checkEmail(object, url) {
  if (object.form.email.value.trim().length === 0) {
    alert("이메일을 입력하세요!");
    return;
  }

  // TODO : Ajax로 url에 중복 이메일 검사.
  $.ajax({
    url: url,
    type: "get",
    dataType: "json",
    data: "",
    success: function (response) {
      console.log(response);
    },
    error: function (jqXHR, status, error) {
      console.error(status + " : " + error);
    },
  });
}
