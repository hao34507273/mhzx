/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SInviteJoinGang
/*     */   extends __SInviteJoinGang__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589858;
/*     */   public long inviterid;
/*     */   public String invitername;
/*     */   public long gangid;
/*     */   public String gangname;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  29 */     return 12589858;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SInviteJoinGang()
/*     */   {
/*  38 */     this.invitername = "";
/*  39 */     this.gangname = "";
/*     */   }
/*     */   
/*     */   public SInviteJoinGang(long _inviterid_, String _invitername_, long _gangid_, String _gangname_) {
/*  43 */     this.inviterid = _inviterid_;
/*  44 */     this.invitername = _invitername_;
/*  45 */     this.gangid = _gangid_;
/*  46 */     this.gangname = _gangname_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.inviterid);
/*  55 */     _os_.marshal(this.invitername, "UTF-16LE");
/*  56 */     _os_.marshal(this.gangid);
/*  57 */     _os_.marshal(this.gangname, "UTF-16LE");
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.inviterid = _os_.unmarshal_long();
/*  63 */     this.invitername = _os_.unmarshal_String("UTF-16LE");
/*  64 */     this.gangid = _os_.unmarshal_long();
/*  65 */     this.gangname = _os_.unmarshal_String("UTF-16LE");
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SInviteJoinGang)) {
/*  75 */       SInviteJoinGang _o_ = (SInviteJoinGang)_o1_;
/*  76 */       if (this.inviterid != _o_.inviterid) return false;
/*  77 */       if (!this.invitername.equals(_o_.invitername)) return false;
/*  78 */       if (this.gangid != _o_.gangid) return false;
/*  79 */       if (!this.gangname.equals(_o_.gangname)) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += (int)this.inviterid;
/*  88 */     _h_ += this.invitername.hashCode();
/*  89 */     _h_ += (int)this.gangid;
/*  90 */     _h_ += this.gangname.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.inviterid).append(",");
/*  98 */     _sb_.append("T").append(this.invitername.length()).append(",");
/*  99 */     _sb_.append(this.gangid).append(",");
/* 100 */     _sb_.append("T").append(this.gangname.length()).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SInviteJoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */