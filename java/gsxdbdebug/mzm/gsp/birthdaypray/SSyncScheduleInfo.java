/*    */ package mzm.gsp.birthdaypray;
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
/*    */ public class SSyncScheduleInfo
/*    */   extends __SSyncScheduleInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12623108;
/*    */   public int activity_cfg_id;
/*    */   public HashMap<Integer, Long> task_activity_id2times;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12623108;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncScheduleInfo()
/*    */   {
/* 34 */     this.task_activity_id2times = new HashMap();
/*    */   }
/*    */   
/*    */   public SSyncScheduleInfo(int _activity_cfg_id_, HashMap<Integer, Long> _task_activity_id2times_) {
/* 38 */     this.activity_cfg_id = _activity_cfg_id_;
/* 39 */     this.task_activity_id2times = _task_activity_id2times_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.activity_cfg_id);
/* 48 */     _os_.compact_uint32(this.task_activity_id2times.size());
/* 49 */     for (Map.Entry<Integer, Long> _e_ : this.task_activity_id2times.entrySet()) {
/* 50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 51 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 60 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 62 */       long _v_ = _os_.unmarshal_long();
/* 63 */       this.task_activity_id2times.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SSyncScheduleInfo)) {
/* 74 */       SSyncScheduleInfo _o_ = (SSyncScheduleInfo)_o1_;
/* 75 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 76 */       if (!this.task_activity_id2times.equals(_o_.task_activity_id2times)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.activity_cfg_id;
/* 85 */     _h_ += this.task_activity_id2times.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.activity_cfg_id).append(",");
/* 93 */     _sb_.append(this.task_activity_id2times).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\SSyncScheduleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */