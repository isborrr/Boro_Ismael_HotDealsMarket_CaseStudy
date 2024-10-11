const form = document.getElementById('signupForm');

form.addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent form submission

    let valid = true;

    // First name validation (only letters)
    const firstName = document.getElementById('firstName').value;
    if (!/^[A-Za-z]+$/.test(firstName)) {
        document.getElementById('firstNameError').style.display = 'block';
        valid = false;
    } else {
        document.getElementById('firstNameError').style.display = 'none';
    }

    // Last name validation (only letters)
    const lastName = document.getElementById('lastName').value;
    if (!/^[A-Za-z]+$/.test(lastName)) {
        document.getElementById('lastNameError').style.display = 'block';
        valid = false;
    } else {
        document.getElementById('lastNameError').style.display = 'none';
    }

    // Email validation (simple regex for basic format)
    const email = document.getElementById('email').value;
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
        document.getElementById('emailError').style.display = 'block';
        valid = false;
    } else {
        document.getElementById('emailError').style.display = 'none';
    }

    // Phone number validation (must be 10 digits)
    const phone = document.getElementById('phone').value;
    if (!/^\d{10}$/.test(phone)) {
        document.getElementById('phoneError').style.display = 'block';
        valid = false;
    } else {
        document.getElementById('phoneError').style.display = 'none';
    }

    // Password validation (minimum 6 characters)
    const password = document.getElementById('password').value;
    if (password.length < 6) {
        document.getElementById('passwordError').style.display = 'block';
        valid = false;
    } else {
        document.getElementById('passwordError').style.display = 'none';
    }

    if (valid) {
        alert('Sign up Successfully');
        // Here, you can submit the form data or proceed further.
    }
});
