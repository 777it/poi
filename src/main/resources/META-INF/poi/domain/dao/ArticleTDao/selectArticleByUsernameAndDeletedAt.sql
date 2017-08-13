select
    id
   ,title
   ,body
   ,category
   ,level
   ,updated_at
from
    article_t
where
  username = /* username */'poi' and
  deleted_at is null
order by updated_at desc