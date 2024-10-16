// const form = document.getElementById('signinForm');
//
// form.addEventListener('submit', function (event) {
//     // event.preventDefault(); // Prevent form submission
//
//     let valid = true;
//
//
//     // Email validation (simple regex for basic format)
//     const email = document.getElementById('email').value;
//     if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
//         document.getElementById('emailError').style.display = 'block';
//         valid = false;
//     } else {
//         document.getElementById('emailError').style.display = 'none';
//     }
//
//
//     // Password validation (minimum 6 characters)
//     const password = document.getElementById('password').value;
//     if (password.length < 6) {
//         document.getElementById('passwordError').style.display = 'block';
//         valid = false;
//     } else {
//         document.getElementById('passwordError').style.display = 'none';
//     }
//
//     if (valid) {
//         // alert('Sign in Successfully!');
//         // this.submit(); // Submit the form manually after successful validation
//         // Here, you can submit the form data or proceed further.
//     }
// });
