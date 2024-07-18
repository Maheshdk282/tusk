<!---books.xml----->
<?xml version="1.0" encoding="UTF-8" standalone = "yes"?>
<?xml-stylesheet type="text/xsl" href="books.xsl"?>
<!DOCTYPE bookstore [
<!ELEMENT bookstore (book+)>
<!ELEMENT book (title, author, isbn, publisher, edition, price)>
<!ELEMENT title (#PCDATA)>
<!ELEMENT author (#PCDATA)>
<!ELEMENT isbn (#PCDATA)>
<!ELEMENT publisher (#PCDATA)>
<!ELEMENT edition (#PCDATA)>
<!ELEMENT price (#PCDATA)>
]>
<bookstore>
    <book>
        <title>Example Book Title</title>
        <author>John Doe</author>
        <isbn>1234567890</isbn>
        <publisher>Example Publisher</publisher>
        <edition>1st</edition>
        <price>29.99</price>
    </book>
</bookstore>

<!---books.xsl----->
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Bookstore</title>
                <style>
                    table { 
                        width: 100%; 
                        border-collapse: collapse; 
                    }
                    table, th, td { 
                        border: 1px solid black; 
                    }
                    th, td { 
                        padding: 10px; 
                        text-align: left; 
                    }
                    th { 
                        background-color: #f2f2f2; 
                    }
                </style>
            </head>
            <body>
                <h2>Bookstore</h2>
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Author</th>
                        <th>ISBN</th>
                        <th>Publisher</th>
                        <th>Edition</th>
                        <th>Price</th>
                    </tr>
                    <xsl:for-each select="bookstore/book">
                        <tr>
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="author"/></td>
                            <td><xsl:value-of select="isbn"/></td>
                            <td><xsl:value-of select="publisher"/></td>
                            <td><xsl:value-of select="edition"/></td>
                            <td><xsl:value-of select="price"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
