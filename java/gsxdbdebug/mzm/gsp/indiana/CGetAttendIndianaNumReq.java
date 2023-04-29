/*     */ package mzm.gsp.indiana;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.indiana.main.IndianaOneByOneManager;
/*     */ import mzm.gsp.indiana.main.PCGetAttendIndianaNum;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ 
/*     */ public class CGetAttendIndianaNumReq
/*     */   extends __CGetAttendIndianaNumReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628996;
/*     */   public int activity_cfg_id;
/*     */   public int turn;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     if (roleid < 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(this.activity_cfg_id)).add(new PCGetAttendIndianaNum(roleid, this.activity_cfg_id, this.turn));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12628996;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetAttendIndianaNumReq() {}
/*     */   
/*     */ 
/*     */   public CGetAttendIndianaNumReq(int _activity_cfg_id_, int _turn_)
/*     */   {
/*  43 */     this.activity_cfg_id = _activity_cfg_id_;
/*  44 */     this.turn = _turn_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activity_cfg_id);
/*  53 */     _os_.marshal(this.turn);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  59 */     this.turn = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CGetAttendIndianaNumReq)) {
/*  69 */       CGetAttendIndianaNumReq _o_ = (CGetAttendIndianaNumReq)_o1_;
/*  70 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  71 */       if (this.turn != _o_.turn) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.activity_cfg_id;
/*  80 */     _h_ += this.turn;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activity_cfg_id).append(",");
/*  88 */     _sb_.append(this.turn).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetAttendIndianaNumReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.turn - _o_.turn;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\CGetAttendIndianaNumReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */