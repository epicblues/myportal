function checkEmail(object, url) {
	if (object.form.email.value.trim().length === 0) {
		alert("이메일을 입력하세요!");
		return;
	}
	console.log(object.form.email.value);

	// TODO : Ajax로 url에 중복 이메일 검사.
	// $.ajax({
	//   url: "http://localhost:8080" + url,
	//   type: "get",
	//   dataType: "json",
	//   data: JSON.stringify({ email: object.form.email.value }),
	//   success: function (response) {
	//     console.log(response);
	//   },
	//   error: function (jqXHR, status, error) {
	//     console.error(status + " : " + error);
	//   },
	// });

	fetch(url, {
		headers: {
			"Content-Type": "application/json; charset=UTF-8",
		},
		method: "POST",
		body: JSON.stringify({ email: object.form.email.value }),
	})
		.then((resp) => resp.json())
		.then((json) => {
			if (!json.result) {
				alert("사용 가능합니다!");
				document.querySelector("[type='submit']").disabled = false;
			} else {
				alert("이메일이 중복되었습니다!");
				object.form.email.value = "";
				document.querySelector("[type='submit']").disabled = true;
			}
		})
		.catch(console.error);
}
