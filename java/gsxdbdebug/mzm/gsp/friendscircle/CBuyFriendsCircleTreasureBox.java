/*     */ package mzm.gsp.friendscircle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.friendscircle.main.PCBuyFriendsCircleTreasureBox;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CBuyFriendsCircleTreasureBox
/*     */   extends __CBuyFriendsCircleTreasureBox__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625415;
/*     */   public int buy_count;
/*     */   public long client_currency_value;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCBuyFriendsCircleTreasureBox(roleId, this.buy_count, this.client_currency_value));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12625415;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyFriendsCircleTreasureBox() {}
/*     */   
/*     */ 
/*     */   public CBuyFriendsCircleTreasureBox(int _buy_count_, long _client_currency_value_)
/*     */   {
/*  43 */     this.buy_count = _buy_count_;
/*  44 */     this.client_currency_value = _client_currency_value_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.buy_count);
/*  53 */     _os_.marshal(this.client_currency_value);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.buy_count = _os_.unmarshal_int();
/*  59 */     this.client_currency_value = _os_.unmarshal_long();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CBuyFriendsCircleTreasureBox)) {
/*  69 */       CBuyFriendsCircleTreasureBox _o_ = (CBuyFriendsCircleTreasureBox)_o1_;
/*  70 */       if (this.buy_count != _o_.buy_count) return false;
/*  71 */       if (this.client_currency_value != _o_.client_currency_value) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.buy_count;
/*  80 */     _h_ += (int)this.client_currency_value;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.buy_count).append(",");
/*  88 */     _sb_.append(this.client_currency_value).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyFriendsCircleTreasureBox _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.buy_count - _o_.buy_count;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = Long.signum(this.client_currency_value - _o_.client_currency_value);
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\CBuyFriendsCircleTreasureBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */