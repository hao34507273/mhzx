/*     */ package mzm.gsp.task;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class STaskInitData
/*     */   extends __STaskInitData__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592137;
/*     */   public ArrayList<TaskData> taskdatas;
/*     */   public HashMap<Integer, Integer> setgraphring;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12592137;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public STaskInitData()
/*     */   {
/*  32 */     this.taskdatas = new ArrayList();
/*  33 */     this.setgraphring = new HashMap();
/*     */   }
/*     */   
/*     */   public STaskInitData(ArrayList<TaskData> _taskdatas_, HashMap<Integer, Integer> _setgraphring_) {
/*  37 */     this.taskdatas = _taskdatas_;
/*  38 */     this.setgraphring = _setgraphring_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     for (TaskData _v_ : this.taskdatas)
/*  43 */       if (!_v_._validator_()) return false;
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.compact_uint32(this.taskdatas.size());
/*  49 */     for (TaskData _v_ : this.taskdatas) {
/*  50 */       _os_.marshal(_v_);
/*     */     }
/*  52 */     _os_.compact_uint32(this.setgraphring.size());
/*  53 */     for (Map.Entry<Integer, Integer> _e_ : this.setgraphring.entrySet()) {
/*  54 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  55 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  62 */       TaskData _v_ = new TaskData();
/*  63 */       _v_.unmarshal(_os_);
/*  64 */       this.taskdatas.add(_v_);
/*     */     }
/*  66 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  68 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  70 */       int _v_ = _os_.unmarshal_int();
/*  71 */       this.setgraphring.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof STaskInitData)) {
/*  82 */       STaskInitData _o_ = (STaskInitData)_o1_;
/*  83 */       if (!this.taskdatas.equals(_o_.taskdatas)) return false;
/*  84 */       if (!this.setgraphring.equals(_o_.setgraphring)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.taskdatas.hashCode();
/*  93 */     _h_ += this.setgraphring.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.taskdatas).append(",");
/* 101 */     _sb_.append(this.setgraphring).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\STaskInitData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */