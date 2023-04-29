/*     */ package mzm.gsp.friendscircle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.friendscircle.main.PCAddFriendsCircleBlacklist;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CAddFriendsCircleBlacklist
/*     */   extends __CAddFriendsCircleBlacklist__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625428;
/*     */   public long black_role_id;
/*     */   public int black_role_server_id;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCAddFriendsCircleBlacklist(roleId, this.black_role_id, this.black_role_server_id));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12625428;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CAddFriendsCircleBlacklist() {}
/*     */   
/*     */ 
/*     */   public CAddFriendsCircleBlacklist(long _black_role_id_, int _black_role_server_id_)
/*     */   {
/*  43 */     this.black_role_id = _black_role_id_;
/*  44 */     this.black_role_server_id = _black_role_server_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.black_role_id);
/*  53 */     _os_.marshal(this.black_role_server_id);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.black_role_id = _os_.unmarshal_long();
/*  59 */     this.black_role_server_id = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CAddFriendsCircleBlacklist)) {
/*  69 */       CAddFriendsCircleBlacklist _o_ = (CAddFriendsCircleBlacklist)_o1_;
/*  70 */       if (this.black_role_id != _o_.black_role_id) return false;
/*  71 */       if (this.black_role_server_id != _o_.black_role_server_id) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += (int)this.black_role_id;
/*  80 */     _h_ += this.black_role_server_id;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.black_role_id).append(",");
/*  88 */     _sb_.append(this.black_role_server_id).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAddFriendsCircleBlacklist _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.black_role_id - _o_.black_role_id);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.black_role_server_id - _o_.black_role_server_id;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\CAddFriendsCircleBlacklist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */