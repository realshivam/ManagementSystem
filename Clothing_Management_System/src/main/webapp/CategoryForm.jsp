<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-900">

<%
	
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");	
	
		if(session.getAttribute("email")==null)
		{
			
			response.sendRedirect("login.jsp");		
		}
		
		
		
	
	%>	
<!--
		<form action="AddCategory" method="post">
		<input placeholder="Category Name" type="text" name="CategoryName"><br>
		
		<input type="submit" value="Create">
		</form> -->
		
<!-- component -->
<div class="flex flex-col max-w-4xl md:h-56 bg-white rounded-lg shadow-lg overflow-hidden md:flex-row my-10">
        <div class="md:flex items-center justify-center md:w-1/2 md:bg-gray-700">
            <div class="py-6 px-8 md:py-0">
                <h2 class="text-gray-700 text-2xl font-bold md:text-gray-100">Click on Create</h2>
                <p class="mt-2 text-gray-600 md:text-gray-400">to create a category example : Shirt</p>
            </div>
        </div>
        <div class="flex items-center justify-center pb-6 md:py-0 md:w-1/2 md:border-b-8 border-gray-700">
            <form action="AddCategory" method="post">
                <div class="flex flex-col rounded-lg overflow-hidden sm:flex-row">
                    <input class="py-3 px-4 bg-gray-200 text-gray-800 border-gray-300 border-2 outline-none placeholder-gray-500 focus:bg-gray-100" type="text" name="CategoryName" placeholder="Category Name">
                 
                    <input type="submit" class="py-3 px-4 bg-gray-700 text-gray-100 font-semibold uppercase hover:bg-gray-600" value="Create">
                </div>
            </form>
        </div>
    </div>
</body>
</html>