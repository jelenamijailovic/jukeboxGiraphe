 insert into node (id,node_type,properties)
  values ('1','Genre','{"name": "Rock"}'),
  		 ('2','Genre','{"name": "Punk"}'),
 		 ('3','Genre','{"name": "Narodna"}');
 		 
insert into node (id,node_type,properties)
  values ('4','Artist','{"name": "EKV"}'),
  		 ('5','Artist','{"name": "Goblini"}'),
 		 ('6','Artist','{"name": "Silvana"}');
 
insert into node (id,node_type,properties)
  values ('7','Price','{"price": "100"}'),
  		 ('8','Price','{"price": "150"}'),
 		 ('9','Price','{"price": "50"}');
 		 
insert into node (id,node_type,properties)
  values ('10','Song','{"name": "Srce"}'),
  		 ('11','Song','{"name": "Voz"}'),
 		 ('12','Song','{"name": "Sta ce mi zivot"}');
 		 
insert into node (id,node_type,properties)
  values ('13','Traffic','{}'),
  		 ('14','Traffic','{}'),
 		 ('15','Traffic','{}');
  
insert into edge (id,edge_type,from_node_id,to_node_id,properties)
  values ('1','contains','1','4','{}'),
  		 ('2','relates','7','10','{}'),
  		 ('3','sings','4','10','{}'),
  		 ('4','placed','10','13','{}'),
  		 ('5','contains','2','5','{}'),
  		 ('6','relates','8','11','{}'),
  		 ('7','sings','5','11','{}'),
  		 ('8','placed','11','14','{}'),
  		 ('9','contains','3','6','{}'),
  		 ('10','relates','9','12','{}'),
  		 ('11','sings','6','12','{}'),
  		 ('12','placed','12','15','{}');