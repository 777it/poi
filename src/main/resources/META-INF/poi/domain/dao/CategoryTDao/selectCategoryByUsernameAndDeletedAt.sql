select
    id
   ,category
   ,updated_at
from
    category_t
where
  username = /* username */'poi' and
  deleted_at is null