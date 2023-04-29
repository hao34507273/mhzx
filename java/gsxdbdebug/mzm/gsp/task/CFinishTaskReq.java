/*     */ package mzm.gsp.task;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public class CFinishTaskReq extends __CFinishTaskReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592131;
/*     */   public int taskid;
/*     */   public int graphid;
/*     */   public LinkedList<Long> giveoutpet;
/*     */   public LinkedList<GiveoutItemBean> giveoutitem;
/*     */   
/*     */   protected void process()
/*     */   {
/*  16 */     long roleId = mzm.gsp.Role.getRoleId(this);
/*  17 */     if (roleId < 0L) {
/*  18 */       return;
/*     */     }
/*  20 */     mzm.gsp.Role.addRoleProcedure(roleId, new mzm.gsp.task.main.FinishTaskProcedure(roleId, this.graphid, this.taskid, this.giveoutitem, this.giveoutpet));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12592131;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CFinishTaskReq()
/*     */   {
/*  39 */     this.giveoutpet = new LinkedList();
/*  40 */     this.giveoutitem = new LinkedList();
/*     */   }
/*     */   
/*     */   public CFinishTaskReq(int _taskid_, int _graphid_, LinkedList<Long> _giveoutpet_, LinkedList<GiveoutItemBean> _giveoutitem_) {
/*  44 */     this.taskid = _taskid_;
/*  45 */     this.graphid = _graphid_;
/*  46 */     this.giveoutpet = _giveoutpet_;
/*  47 */     this.giveoutitem = _giveoutitem_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     for (GiveoutItemBean _v_ : this.giveoutitem)
/*  52 */       if (!_v_._validator_()) return false;
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.taskid);
/*  58 */     _os_.marshal(this.graphid);
/*  59 */     _os_.compact_uint32(this.giveoutpet.size());
/*  60 */     for (Long _v_ : this.giveoutpet) {
/*  61 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  63 */     _os_.compact_uint32(this.giveoutitem.size());
/*  64 */     for (GiveoutItemBean _v_ : this.giveoutitem) {
/*  65 */       _os_.marshal(_v_);
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  71 */     this.taskid = _os_.unmarshal_int();
/*  72 */     this.graphid = _os_.unmarshal_int();
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  75 */       long _v_ = _os_.unmarshal_long();
/*  76 */       this.giveoutpet.add(Long.valueOf(_v_));
/*     */     }
/*  78 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  79 */       GiveoutItemBean _v_ = new GiveoutItemBean();
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.giveoutitem.add(_v_);
/*     */     }
/*  83 */     if (!_validator_()) {
/*  84 */       throw new VerifyError("validator failed");
/*     */     }
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  90 */     if (_o1_ == this) return true;
/*  91 */     if ((_o1_ instanceof CFinishTaskReq)) {
/*  92 */       CFinishTaskReq _o_ = (CFinishTaskReq)_o1_;
/*  93 */       if (this.taskid != _o_.taskid) return false;
/*  94 */       if (this.graphid != _o_.graphid) return false;
/*  95 */       if (!this.giveoutpet.equals(_o_.giveoutpet)) return false;
/*  96 */       if (!this.giveoutitem.equals(_o_.giveoutitem)) return false;
/*  97 */       return true;
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     int _h_ = 0;
/* 104 */     _h_ += this.taskid;
/* 105 */     _h_ += this.graphid;
/* 106 */     _h_ += this.giveoutpet.hashCode();
/* 107 */     _h_ += this.giveoutitem.hashCode();
/* 108 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 112 */     StringBuilder _sb_ = new StringBuilder();
/* 113 */     _sb_.append("(");
/* 114 */     _sb_.append(this.taskid).append(",");
/* 115 */     _sb_.append(this.graphid).append(",");
/* 116 */     _sb_.append(this.giveoutpet).append(",");
/* 117 */     _sb_.append(this.giveoutitem).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\CFinishTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */