select
   category
from
    category_t
where
  username = /* username */'poi' and
  category = /* category */'poi' and
  deleted_at is null