SELECT COUNT(L_MS_ID) FROM LINK_MANGA_SERVER;

SELECT L_MS_ID, M_ID, M_NAME, S_NAME, L_MS_URL, L_MS_LASTUPDATE FROM LINK_MANGA_SERVER 
    INNER JOIN MANGAS ON M_ID = L_MS_MANGA
    INNER JOIN SERVERS ON S_ID = L_MS_SERVER        

SELECT * FROM Mangas
    WHERE M_Name LIKE 'Advance of Z: The Flag of Titans'