/*    */ package mzm.gsp.worldgoal;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
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
/*    */ public class SSyncRoleWorldGoalInfo
/*    */   extends __SSyncRoleWorldGoalInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594439;
/*    */   public HashMap<Integer, Integer> role_world_goal_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594439;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncRoleWorldGoalInfo()
/*    */   {
/* 33 */     this.role_world_goal_info = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncRoleWorldGoalInfo(HashMap<Integer, Integer> _role_world_goal_info_) {
/* 37 */     this.role_world_goal_info = _role_world_goal_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.role_world_goal_info.size());
/* 46 */     for (Map.Entry<Integer, Integer> _e_ : this.role_world_goal_info.entrySet()) {
/* 47 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 48 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 56 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 58 */       int _v_ = _os_.unmarshal_int();
/* 59 */       this.role_world_goal_info.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SSyncRoleWorldGoalInfo)) {
/* 70 */       SSyncRoleWorldGoalInfo _o_ = (SSyncRoleWorldGoalInfo)_o1_;
/* 71 */       if (!this.role_world_goal_info.equals(_o_.role_world_goal_info)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.role_world_goal_info.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.role_world_goal_info).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\SSyncRoleWorldGoalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */