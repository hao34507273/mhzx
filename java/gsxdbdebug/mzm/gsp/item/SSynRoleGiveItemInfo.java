/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynRoleGiveItemInfo
/*     */   extends __SSynRoleGiveItemInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584773;
/*     */   public HashMap<Long, Integer> roleid2count;
/*     */   public HashMap<Long, Long> roleid2yuanbao;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584773;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynRoleGiveItemInfo()
/*     */   {
/*  32 */     this.roleid2count = new HashMap();
/*  33 */     this.roleid2yuanbao = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynRoleGiveItemInfo(HashMap<Long, Integer> _roleid2count_, HashMap<Long, Long> _roleid2yuanbao_) {
/*  37 */     this.roleid2count = _roleid2count_;
/*  38 */     this.roleid2yuanbao = _roleid2yuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.compact_uint32(this.roleid2count.size());
/*  47 */     for (Map.Entry<Long, Integer> _e_ : this.roleid2count.entrySet()) {
/*  48 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  49 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  51 */     _os_.compact_uint32(this.roleid2yuanbao.size());
/*  52 */     for (Map.Entry<Long, Long> _e_ : this.roleid2yuanbao.entrySet()) {
/*  53 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  54 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  62 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  64 */       int _v_ = _os_.unmarshal_int();
/*  65 */       this.roleid2count.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  67 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  69 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  71 */       long _v_ = _os_.unmarshal_long();
/*  72 */       this.roleid2yuanbao.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SSynRoleGiveItemInfo)) {
/*  83 */       SSynRoleGiveItemInfo _o_ = (SSynRoleGiveItemInfo)_o1_;
/*  84 */       if (!this.roleid2count.equals(_o_.roleid2count)) return false;
/*  85 */       if (!this.roleid2yuanbao.equals(_o_.roleid2yuanbao)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.roleid2count.hashCode();
/*  94 */     _h_ += this.roleid2yuanbao.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.roleid2count).append(",");
/* 102 */     _sb_.append(this.roleid2yuanbao).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SSynRoleGiveItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */