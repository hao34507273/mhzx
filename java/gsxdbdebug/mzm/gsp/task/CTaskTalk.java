/*     */ package mzm.gsp.task;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CTaskTalk extends __CTaskTalk__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592135;
/*     */   public int taskid;
/*     */   public int graphid;
/*     */   public int talktype;
/*     */   public int talkindex;
/*     */   
/*     */   protected void process()
/*     */   {
/*  17 */     long roleId = Role.getRoleId(this);
/*  18 */     if (roleId < 0L) {
/*  19 */       return;
/*     */     }
/*  21 */     Role.addRoleProcedure(roleId, new mzm.gsp.task.main.PTaskTalkBro(roleId, this.taskid, this.graphid, this.talktype, this.talkindex));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12592135;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CTaskTalk() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CTaskTalk(int _taskid_, int _graphid_, int _talktype_, int _talkindex_)
/*     */   {
/*  41 */     this.taskid = _taskid_;
/*  42 */     this.graphid = _graphid_;
/*  43 */     this.talktype = _talktype_;
/*  44 */     this.talkindex = _talkindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.taskid);
/*  53 */     _os_.marshal(this.graphid);
/*  54 */     _os_.marshal(this.talktype);
/*  55 */     _os_.marshal(this.talkindex);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.taskid = _os_.unmarshal_int();
/*  61 */     this.graphid = _os_.unmarshal_int();
/*  62 */     this.talktype = _os_.unmarshal_int();
/*  63 */     this.talkindex = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CTaskTalk)) {
/*  73 */       CTaskTalk _o_ = (CTaskTalk)_o1_;
/*  74 */       if (this.taskid != _o_.taskid) return false;
/*  75 */       if (this.graphid != _o_.graphid) return false;
/*  76 */       if (this.talktype != _o_.talktype) return false;
/*  77 */       if (this.talkindex != _o_.talkindex) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.taskid;
/*  86 */     _h_ += this.graphid;
/*  87 */     _h_ += this.talktype;
/*  88 */     _h_ += this.talkindex;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.taskid).append(",");
/*  96 */     _sb_.append(this.graphid).append(",");
/*  97 */     _sb_.append(this.talktype).append(",");
/*  98 */     _sb_.append(this.talkindex).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CTaskTalk _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.taskid - _o_.taskid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.graphid - _o_.graphid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.talktype - _o_.talktype;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.talkindex - _o_.talkindex;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\CTaskTalk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */