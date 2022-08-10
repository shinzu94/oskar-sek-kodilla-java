select i.*, il.NAME
from ISSUES as i
         left join ISSUESLISTS il on i.ISSUESLIST_ID = il.ID;

select *
from ISSUES as i
         left join USERS as u on i.USER_ID_ASSIGNEDTO = u.ID;

select u.ID, concat(u.FIRSTNAME, ' ', u.LASTNAME), count(i.id) as count
from USERS as u
    left join ISSUES i
on u.ID = i.USER_ID_ASSIGNEDTO
group by u.id
having count > 0;