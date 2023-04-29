/*     */ package mzm.gsp.shitu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class ShiTuTaskInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int NO_PUBLISHED = 0;
/*     */   public static final int YES_PUBLISHED = 1;
/*     */   public static final int APPRENTICE_RECEIVED = 2;
/*     */   public static final int RECEIVE_MAX_LEVEL = 3;
/*     */   public static final int RECEIVE_MAX_TIMES = 4;
/*     */   public static final int LEAVE_MASTER_TODAY = 5;
/*     */   public static final int CHU_SHI = 6;
/*     */   public static final int MAX_PUBLISH_TIMES = 7;
/*     */   public long role_id;
/*     */   public int publish_state;
/*     */   public int refresh_times;
/*     */   public int shitu_task_count;
/*     */   public HashMap<Integer, ShiTuTask> task_infos;
/*     */   
/*     */   public ShiTuTaskInfo()
/*     */   {
/*  25 */     this.task_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public ShiTuTaskInfo(long _role_id_, int _publish_state_, int _refresh_times_, int _shitu_task_count_, HashMap<Integer, ShiTuTask> _task_infos_) {
/*  29 */     this.role_id = _role_id_;
/*  30 */     this.publish_state = _publish_state_;
/*  31 */     this.refresh_times = _refresh_times_;
/*  32 */     this.shitu_task_count = _shitu_task_count_;
/*  33 */     this.task_infos = _task_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  37 */     for (Map.Entry<Integer, ShiTuTask> _e_ : this.task_infos.entrySet()) {
/*  38 */       if (!((ShiTuTask)_e_.getValue())._validator_()) return false;
/*     */     }
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  44 */     _os_.marshal(this.role_id);
/*  45 */     _os_.marshal(this.publish_state);
/*  46 */     _os_.marshal(this.refresh_times);
/*  47 */     _os_.marshal(this.shitu_task_count);
/*  48 */     _os_.compact_uint32(this.task_infos.size());
/*  49 */     for (Map.Entry<Integer, ShiTuTask> _e_ : this.task_infos.entrySet()) {
/*  50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  51 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  57 */     this.role_id = _os_.unmarshal_long();
/*  58 */     this.publish_state = _os_.unmarshal_int();
/*  59 */     this.refresh_times = _os_.unmarshal_int();
/*  60 */     this.shitu_task_count = _os_.unmarshal_int();
/*  61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  63 */       int _k_ = _os_.unmarshal_int();
/*  64 */       ShiTuTask _v_ = new ShiTuTask();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.task_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof ShiTuTaskInfo)) {
/*  74 */       ShiTuTaskInfo _o_ = (ShiTuTaskInfo)_o1_;
/*  75 */       if (this.role_id != _o_.role_id) return false;
/*  76 */       if (this.publish_state != _o_.publish_state) return false;
/*  77 */       if (this.refresh_times != _o_.refresh_times) return false;
/*  78 */       if (this.shitu_task_count != _o_.shitu_task_count) return false;
/*  79 */       if (!this.task_infos.equals(_o_.task_infos)) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += (int)this.role_id;
/*  88 */     _h_ += this.publish_state;
/*  89 */     _h_ += this.refresh_times;
/*  90 */     _h_ += this.shitu_task_count;
/*  91 */     _h_ += this.task_infos.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.role_id).append(",");
/*  99 */     _sb_.append(this.publish_state).append(",");
/* 100 */     _sb_.append(this.refresh_times).append(",");
/* 101 */     _sb_.append(this.shitu_task_count).append(",");
/* 102 */     _sb_.append(this.task_infos).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\ShiTuTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */