/*    */ package mzm.gsp.achievement;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SAchievementFinishBrd
/*    */   extends __SAchievementFinishBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12603911;
/*    */   public String role_name;
/*    */   public int goal_cfg_id;
/*    */   public long faction_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12603911;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAchievementFinishBrd()
/*    */   {
/* 35 */     this.role_name = "";
/*    */   }
/*    */   
/*    */   public SAchievementFinishBrd(String _role_name_, int _goal_cfg_id_, long _faction_id_) {
/* 39 */     this.role_name = _role_name_;
/* 40 */     this.goal_cfg_id = _goal_cfg_id_;
/* 41 */     this.faction_id = _faction_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.role_name, "UTF-16LE");
/* 50 */     _os_.marshal(this.goal_cfg_id);
/* 51 */     _os_.marshal(this.faction_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.role_name = _os_.unmarshal_String("UTF-16LE");
/* 57 */     this.goal_cfg_id = _os_.unmarshal_int();
/* 58 */     this.faction_id = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SAchievementFinishBrd)) {
/* 68 */       SAchievementFinishBrd _o_ = (SAchievementFinishBrd)_o1_;
/* 69 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 70 */       if (this.goal_cfg_id != _o_.goal_cfg_id) return false;
/* 71 */       if (this.faction_id != _o_.faction_id) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.role_name.hashCode();
/* 80 */     _h_ += this.goal_cfg_id;
/* 81 */     _h_ += (int)this.faction_id;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("T").append(this.role_name.length()).append(",");
/* 89 */     _sb_.append(this.goal_cfg_id).append(",");
/* 90 */     _sb_.append(this.faction_id).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\SAchievementFinishBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */