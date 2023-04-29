/*     */ package mzm.gsp.petmark;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.petmark.main.PCPetMarkLotteryDrawReq;
/*     */ 
/*     */ public class CPetMarkLotteryDrawReq extends __CPetMarkLotteryDrawReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628484;
/*     */   public static final int LOTTERY_TYPE1 = 1;
/*     */   public static final int LOTTERY_TYPE2 = 2;
/*     */   public static final int ONE_LOTTERY = 1;
/*     */   public static final int TEN_LOTTERY = 10;
/*     */   public int lottery_type;
/*     */   public int lottery_num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCPetMarkLotteryDrawReq(roleId, this.lottery_type, this.lottery_num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12628484;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CPetMarkLotteryDrawReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CPetMarkLotteryDrawReq(int _lottery_type_, int _lottery_num_)
/*     */   {
/*  47 */     this.lottery_type = _lottery_type_;
/*  48 */     this.lottery_num = _lottery_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.lottery_type);
/*  57 */     _os_.marshal(this.lottery_num);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.lottery_type = _os_.unmarshal_int();
/*  63 */     this.lottery_num = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CPetMarkLotteryDrawReq)) {
/*  73 */       CPetMarkLotteryDrawReq _o_ = (CPetMarkLotteryDrawReq)_o1_;
/*  74 */       if (this.lottery_type != _o_.lottery_type) return false;
/*  75 */       if (this.lottery_num != _o_.lottery_num) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.lottery_type;
/*  84 */     _h_ += this.lottery_num;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.lottery_type).append(",");
/*  92 */     _sb_.append(this.lottery_num).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CPetMarkLotteryDrawReq _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.lottery_type - _o_.lottery_type;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.lottery_num - _o_.lottery_num;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\CPetMarkLotteryDrawReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */