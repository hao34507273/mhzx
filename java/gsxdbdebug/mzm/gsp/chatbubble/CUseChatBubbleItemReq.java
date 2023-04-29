/*     */ package mzm.gsp.chatbubble;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.chatbubble.main.PCUseChatBubbleItemReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CUseChatBubbleItemReq
/*     */   extends __CUseChatBubbleItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12621827;
/*     */   public int bagid;
/*     */   public int grid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCUseChatBubbleItemReq(roleId, this.bagid, this.grid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12621827;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CUseChatBubbleItemReq() {}
/*     */   
/*     */ 
/*     */   public CUseChatBubbleItemReq(int _bagid_, int _grid_)
/*     */   {
/*  43 */     this.bagid = _bagid_;
/*  44 */     this.grid = _grid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.bagid);
/*  53 */     _os_.marshal(this.grid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.bagid = _os_.unmarshal_int();
/*  59 */     this.grid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CUseChatBubbleItemReq)) {
/*  69 */       CUseChatBubbleItemReq _o_ = (CUseChatBubbleItemReq)_o1_;
/*  70 */       if (this.bagid != _o_.bagid) return false;
/*  71 */       if (this.grid != _o_.grid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.bagid;
/*  80 */     _h_ += this.grid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.bagid).append(",");
/*  88 */     _sb_.append(this.grid).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CUseChatBubbleItemReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.bagid - _o_.bagid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.grid - _o_.grid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\CUseChatBubbleItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */