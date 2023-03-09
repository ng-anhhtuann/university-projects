-- Query books that have been borrowed with name of book and username of the one borrowed --
SELECT books.bookid AS idbook,books.booktitle AS bookname, users.username AS username, books.dayborrowleft AS dayleft
FROM books
JOIN users
ON books.bookid = users.userborrowing and books.borrower = users.userid
WHERE books.borrower IS NOT NULL; 
