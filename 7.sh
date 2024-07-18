<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photo Slideshow</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        #slideshow {
            position: relative;
            width: 80%;
            max-width: 600px;
            margin: auto;
            overflow: hidden;
            border: 2px solid #ddd;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        #slideshow img {
            width: 100%;
            display: none;
        }
        #slideshow img.active {
            display: block;
        }
        .buttons {
            position: absolute;
            top: 50%;
            width: 100%;
            display: flex;
            justify-content: space-between;
            transform: translateY(-50%);
        }
        .buttons button {
            background: rgba(0,0,0,0.5);
            border: none;
            color: white;
            padding: 10px;
            cursor: pointer;
            transition: background 0.3s;
        }
        .buttons button:hover {
            background: rgba(0,0,0,0.8);
        }
    </style>
</head>
<body>
    <div id="slideshow">
        <img src="1.jpg" alt="Image 1" class="active">
        <img src="2.jpg" alt="Image 2">
        <img src="image3.jpg" alt="Image 3">
        <div class="buttons">
            <button id="prev">Prev</button>
            <button id="next">Next</button>
        </div>
    </div>

    <script>
        const images = document.querySelectorAll('#slideshow img');
        const nextButton = document.getElementById('next');
        const prevButton = document.getElementById('prev');
        let currentIndex = 0;

        function showImage(index) {
            images.forEach((img, i) => {
                img.classList.remove('active');
                if (i === index) {
                    img.classList.add('active');
                }
            });
        }

        nextButton.addEventListener('click', () => {
            currentIndex = (currentIndex + 1) % images.length;
            showImage(currentIndex);
        });

        prevButton.addEventListener('click', () => {
            currentIndex = (currentIndex - 1 + images.length) % images.length;
            showImage(currentIndex);
        });

        // Auto slide functionality (optional)
        setInterval(() => {
            currentIndex = (currentIndex + 1) % images.length;
            showImage(currentIndex);
        }, 5000);
    </script>
</body>
</html>
