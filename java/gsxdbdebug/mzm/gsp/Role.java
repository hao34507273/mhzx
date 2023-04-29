/*     */ package mzm.gsp;
/*     */ 
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public class Role
/*     */ {
/*  11 */   private gnet.link.Role m_role = null;
/*  12 */   private java.lang.ref.WeakReference<Role> m_wref = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  17 */   private TaskOneByOne m_tasks = null;
/*     */   
/*     */   public Role(gnet.link.Role role, TaskOneByOne taskOneByOne) {
/*  20 */     if (role == null)
/*     */     {
/*  22 */       throw new RuntimeException("role can not be null");
/*     */     }
/*     */     
/*  25 */     this.m_role = role;
/*  26 */     this.m_wref = new java.lang.ref.WeakReference(this);
/*  27 */     this.m_tasks = taskOneByOne;
/*  28 */     if (this.m_tasks == null) {
/*  29 */       this.m_tasks = new TaskOneByOne(OnlineManager.getInstance().getMaxTaskPerRole());
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean kick(int error) {
/*  34 */     return this.m_role.kick(error);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Role getRole(Protocol p)
/*     */   {
/*  42 */     gnet.link.Role role = gnet.link.Onlines.getInstance().find(p);
/*  43 */     if (role == null) {
/*  44 */       return null;
/*     */     }
/*  46 */     return getRole(role.getRoleid());
/*     */   }
/*     */   
/*     */   public static Role getRole(long roleId)
/*     */   {
/*  51 */     return OnlineManager.getInstance().getRoleById(roleId);
/*     */   }
/*     */   
/*     */   public static long getRoleId(Protocol p)
/*     */   {
/*  56 */     gnet.link.Role role = gnet.link.Onlines.getInstance().find(p);
/*  57 */     return role == null ? -1L : role.getRoleid();
/*     */   }
/*     */   
/*     */   public java.lang.ref.WeakReference<Role> getWRef()
/*     */   {
/*  62 */     return this.m_wref;
/*     */   }
/*     */   
/*     */   public String getUserId()
/*     */   {
/*  67 */     return this.m_role.getUserid();
/*     */   }
/*     */   
/*     */   public long getRoleid()
/*     */   {
/*  72 */     return this.m_role.getRoleid();
/*     */   }
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
/*     */   public boolean send(Protocol p)
/*     */   {
/*  87 */     return OnlineManager.getInstance().send(this.m_role, p);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean sendAtOnce(Protocol p)
/*     */   {
/*  97 */     return OnlineManager.getInstance().sendAtOnce(this.m_role, p);
/*     */   }
/*     */   
/*     */   public void addProcedure(LogicProcedure p)
/*     */   {
/* 102 */     this.m_tasks.add(p);
/*     */   }
/*     */   
/*     */   public void addRunnable(LogicRunnable r)
/*     */   {
/* 107 */     this.m_tasks.add(r);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addRoleProcedure(Protocol protocol, LogicProcedure procedure)
/*     */   {
/* 119 */     Role role = getRole(protocol);
/* 120 */     if (role == null) {
/* 121 */       return false;
/*     */     }
/* 123 */     role.addProcedure(procedure);
/* 124 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addRoleProcedure(long roleid, LogicProcedure procedure)
/*     */   {
/* 136 */     Role role = getRole(roleid);
/* 137 */     if (role == null)
/* 138 */       return false;
/* 139 */     role.addProcedure(procedure);
/* 140 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addRoleRunnable(Protocol protocol, LogicRunnable runnable)
/*     */   {
/* 150 */     Role role = getRole(protocol);
/* 151 */     if (role == null)
/* 152 */       return false;
/* 153 */     role.addRunnable(runnable);
/* 154 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addRoleRunnable(long roleid, LogicRunnable runnable)
/*     */   {
/* 165 */     Role role = getRole(roleid);
/* 166 */     if (role == null)
/* 167 */       return false;
/* 168 */     role.addRunnable(runnable);
/* 169 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\Role.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */