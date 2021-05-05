const inputs = document.querySelectorAll('.input', 'select', 'option');

function focusFunc() {
	let parent = this.parentNode.parentNode;
	parent.classList.add('focus');
}

function blurFunc() {
	let parent = this.parentNode.parentNode;
	if (this.value == "") {
		parent.classList.remove('focus');
	}
}

inputs.forEach(input => {
	input.addEventListener('focus', focusFunc)
	input.addEventListener('blur', blurFunc)
})

$(".toggle-password").click(function () {

	$(this).toggleClass("fa-eye fa-eye-slash");
	var input = $($(this).attr("toggle"));
	if (input.attr("type") == "password") {
		input.attr("type", "text");
	} else {
		input.attr("type", "password");
	}
});
