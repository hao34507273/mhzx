/*     */ package mzm.gsp.friend;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynRoleAddFriendRes
/*     */   extends __SSynRoleAddFriendRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587036;
/*     */   public static final int TYPE_MASSWEDDING = 1;
/*     */   public int triggertype;
/*     */   public long roleid;
/*     */   public String name;
/*     */   public HashMap<Integer, Integer> extrainfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12587036;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynRoleAddFriendRes()
/*     */   {
/*  36 */     this.name = "";
/*  37 */     this.extrainfo = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynRoleAddFriendRes(int _triggertype_, long _roleid_, String _name_, HashMap<Integer, Integer> _extrainfo_) {
/*  41 */     this.triggertype = _triggertype_;
/*  42 */     this.roleid = _roleid_;
/*  43 */     this.name = _name_;
/*  44 */     this.extrainfo = _extrainfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.triggertype);
/*  53 */     _os_.marshal(this.roleid);
/*  54 */     _os_.marshal(this.name, "UTF-16LE");
/*  55 */     _os_.compact_uint32(this.extrainfo.size());
/*  56 */     for (Map.Entry<Integer, Integer> _e_ : this.extrainfo.entrySet()) {
/*  57 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  58 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.triggertype = _os_.unmarshal_int();
/*  65 */     this.roleid = _os_.unmarshal_long();
/*  66 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  67 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  69 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  71 */       int _v_ = _os_.unmarshal_int();
/*  72 */       this.extrainfo.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SSynRoleAddFriendRes)) {
/*  83 */       SSynRoleAddFriendRes _o_ = (SSynRoleAddFriendRes)_o1_;
/*  84 */       if (this.triggertype != _o_.triggertype) return false;
/*  85 */       if (this.roleid != _o_.roleid) return false;
/*  86 */       if (!this.name.equals(_o_.name)) return false;
/*  87 */       if (!this.extrainfo.equals(_o_.extrainfo)) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.triggertype;
/*  96 */     _h_ += (int)this.roleid;
/*  97 */     _h_ += this.name.hashCode();
/*  98 */     _h_ += this.extrainfo.hashCode();
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.triggertype).append(",");
/* 106 */     _sb_.append(this.roleid).append(",");
/* 107 */     _sb_.append("T").append(this.name.length()).append(",");
/* 108 */     _sb_.append(this.extrainfo).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SSynRoleAddFriendRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */