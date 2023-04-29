/*     */ package mzm.gsp;
/*     */ 
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Name2roleid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PHandleDuplicateRoleName
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final String name;
/*     */   private final long roleid;
/*     */   
/*     */   public PHandleDuplicateRoleName(String name, long roleid)
/*     */   {
/* 161 */     this.name = name;
/* 162 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/* 168 */     xbean.Basic xBasic = xtable.Basic.get(Long.valueOf(this.roleid));
/* 169 */     if (xBasic == null)
/*     */     {
/* 171 */       MergeMain.logger().warn(String.format("[gameserverinfo]PHandleDuplicateRoleName.processImp@role not exist|roleid=%d|role_name=%s", new Object[] { Long.valueOf(this.roleid), this.name }));
/*     */       
/*     */ 
/* 174 */       return true;
/*     */     }
/*     */     
/* 177 */     long mainZoneid = MergeMain.getMainZoneid();
/* 178 */     long viceZoneid = MergeMain.getViceZoneid();
/* 179 */     MergeMain.logger().info(String.format("[gameserverinfo]PHandleDuplicateRoleName.processImp@handle duplicate role name done|roleid=%d|role_name=%s|main_zoneid=%d|vice_zoneid=%d", new Object[] { Long.valueOf(this.roleid), this.name, Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 184 */     String newName = this.name + "-" + viceZoneid;
/* 185 */     xBasic.setName(newName);
/*     */     
/* 187 */     Name2roleid.insert(newName, Long.valueOf(this.roleid));
/*     */     
/* 189 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\PHandleDuplicateRoleName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */