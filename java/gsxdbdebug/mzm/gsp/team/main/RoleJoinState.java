/*     */ package mzm.gsp.team.main;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoleJoinState
/*     */ {
/*     */   private int state;
/*     */   
/*     */ 
/*     */   private int tempState;
/*     */   
/*     */   private boolean needTF2Leader;
/*     */   
/*     */   private boolean isInHomeLand;
/*     */   
/*     */ 
/*     */   public int getState()
/*     */   {
/*  19 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(int state)
/*     */   {
/*  24 */     this.state = state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTempState()
/*     */   {
/*  34 */     return this.tempState;
/*     */   }
/*     */   
/*     */   public void setTempState(int tempState)
/*     */   {
/*  39 */     this.tempState = tempState;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAllState(int state, int tempState)
/*     */   {
/*  50 */     setState(state);
/*  51 */     setTempState(tempState);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean needTF2Leader()
/*     */   {
/*  61 */     return this.needTF2Leader;
/*     */   }
/*     */   
/*     */   public void setNeedTF2Leader(boolean needTF2Leader)
/*     */   {
/*  66 */     this.needTF2Leader = needTF2Leader;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isInHomeLand()
/*     */   {
/*  76 */     return this.isInHomeLand;
/*     */   }
/*     */   
/*     */   public void setInHomeLand(boolean isInHomeLand)
/*     */   {
/*  81 */     this.isInHomeLand = isInHomeLand;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/*  87 */     StringBuffer sb = new StringBuffer();
/*  88 */     sb.append("{");
/*  89 */     sb.append("state=");
/*  90 */     sb.append(this.state);
/*  91 */     sb.append(",");
/*  92 */     sb.append("tempState=");
/*  93 */     sb.append(this.tempState);
/*  94 */     sb.append(",");
/*  95 */     sb.append("needTF2Leader=");
/*  96 */     sb.append(this.needTF2Leader);
/*  97 */     sb.append(",");
/*  98 */     sb.append("isInHomeLand=");
/*  99 */     sb.append(this.isInHomeLand);
/* 100 */     sb.append("}");
/* 101 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\RoleJoinState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */