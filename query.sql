select 
  '                 "'||
  lower(substr(replace(initcap(column_name),'_',''),1,1))|| (substr(replace(initcap(column_name),'_',''),2)) || '"' || ': newData.'||
  lower(substr(replace(initcap(column_name),'_',''),1,1))|| (substr(replace(initcap(column_name),'_',''),2))||',' text
from dba_tab_columns 
where table_name = 'IMP_METRIC_DAILY_V'
order by column_id
/
