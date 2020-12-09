class Office extends  RoomInfo{
        static int id=1;
        public Office(){
                System.out.println("Office number "+ id + " has been created");
                id++;
                if(id>10)id=1;
        }
}
