/*    */ package mzm.gsp.birthdaypray;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
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
/*    */ public class SSyncRewardInfoInfo
/*    */   extends __SSyncRewardInfoInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12623106;
/*    */   public int activity_cfg_id;
/*    */   public HashMap<Integer, RewardStages> task_activity_id2reward_stages;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12623106;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncRewardInfoInfo()
/*    */   {
/* 34 */     this.task_activity_id2reward_stages = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncRewardInfoInfo(int _activity_cfg_id_, HashMap<Integer, RewardStages> _task_activity_id2reward_stages_) {
/* 38 */     this.activity_cfg_id = _activity_cfg_id_;
/* 39 */     this.task_activity_id2reward_stages = _task_activity_id2reward_stages_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Map.Entry<Integer, RewardStages> _e_ : this.task_activity_id2reward_stages.entrySet()) {
/* 44 */       if (!((RewardStages)_e_.getValue())._validator_()) return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.activity_cfg_id);
/* 51 */     _os_.compact_uint32(this.task_activity_id2reward_stages.size());
/* 52 */     for (Map.Entry<Integer, RewardStages> _e_ : this.task_activity_id2reward_stages.entrySet()) {
/* 53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 54 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 63 */       int _k_ = _os_.unmarshal_int();
/* 64 */       RewardStages _v_ = new RewardStages();
/* 65 */       _v_.unmarshal(_os_);
/* 66 */       this.task_activity_id2reward_stages.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SSyncRewardInfoInfo)) {
/* 77 */       SSyncRewardInfoInfo _o_ = (SSyncRewardInfoInfo)_o1_;
/* 78 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 79 */       if (!this.task_activity_id2reward_stages.equals(_o_.task_activity_id2reward_stages)) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += this.activity_cfg_id;
/* 88 */     _h_ += this.task_activity_id2reward_stages.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activity_cfg_id).append(",");
/* 96 */     _sb_.append(this.task_activity_id2reward_stages).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\SSyncRewardInfoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */