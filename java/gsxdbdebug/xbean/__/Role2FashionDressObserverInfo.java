/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.fashiondress.main.FashionDressExpiredObserver;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class Role2FashionDressObserverInfo extends XBean implements xbean.Role2FashionDressObserverInfo
/*     */ {
/*     */   private HashMap<Integer, FashionDressExpiredObserver> observer_map;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.observer_map.clear();
/*     */   }
/*     */   
/*     */   Role2FashionDressObserverInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.observer_map = new HashMap();
/*     */   }
/*     */   
/*     */   public Role2FashionDressObserverInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Role2FashionDressObserverInfo(Role2FashionDressObserverInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Role2FashionDressObserverInfo(xbean.Role2FashionDressObserverInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  46 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  52 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  58 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  64 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  70 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2FashionDressObserverInfo copy()
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     return new Role2FashionDressObserverInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2FashionDressObserverInfo toData()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2FashionDressObserverInfo toBean()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     return new Role2FashionDressObserverInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2FashionDressObserverInfo toDataIf()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2FashionDressObserverInfo toBeanIf()
/*     */   {
/* 102 */     _xdb_verify_unsafe_();
/* 103 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/* 110 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<Integer, FashionDressExpiredObserver> getObserver_map()
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/* 118 */     return xdb.Logs.logMap(new xdb.LogKey(this, "observer_map"), this.observer_map);
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 124 */     _xdb_verify_unsafe_();
/* 125 */     Role2FashionDressObserverInfo _o_ = null;
/* 126 */     if ((_o1_ instanceof Role2FashionDressObserverInfo)) { _o_ = (Role2FashionDressObserverInfo)_o1_;
/* 127 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 128 */       return false;
/* 129 */     if (!this.observer_map.equals(_o_.observer_map)) return false;
/* 130 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/* 137 */     int _h_ = 0;
/* 138 */     _h_ += this.observer_map.hashCode();
/* 139 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/* 146 */     StringBuilder _sb_ = new StringBuilder();
/* 147 */     _sb_.append("(");
/* 148 */     _sb_.append(this.observer_map);
/* 149 */     _sb_.append(")");
/* 150 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 156 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 157 */     lb.add(new xdb.logs.ListenableMap().setVarName("observer_map"));
/* 158 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Role2FashionDressObserverInfo {
/*     */     private Const() {}
/*     */     
/*     */     Role2FashionDressObserverInfo nThis() {
/* 165 */       return Role2FashionDressObserverInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 171 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2FashionDressObserverInfo copy()
/*     */     {
/* 177 */       return Role2FashionDressObserverInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2FashionDressObserverInfo toData()
/*     */     {
/* 183 */       return Role2FashionDressObserverInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Role2FashionDressObserverInfo toBean()
/*     */     {
/* 188 */       return Role2FashionDressObserverInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2FashionDressObserverInfo toDataIf()
/*     */     {
/* 194 */       return Role2FashionDressObserverInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Role2FashionDressObserverInfo toBeanIf()
/*     */     {
/* 199 */       return Role2FashionDressObserverInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, FashionDressExpiredObserver> getObserver_map()
/*     */     {
/* 206 */       Role2FashionDressObserverInfo.this._xdb_verify_unsafe_();
/* 207 */       return xdb.Consts.constMap(Role2FashionDressObserverInfo.this.observer_map);
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 213 */       Role2FashionDressObserverInfo.this._xdb_verify_unsafe_();
/* 214 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 220 */       Role2FashionDressObserverInfo.this._xdb_verify_unsafe_();
/* 221 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 227 */       return Role2FashionDressObserverInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 233 */       return Role2FashionDressObserverInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 239 */       Role2FashionDressObserverInfo.this._xdb_verify_unsafe_();
/* 240 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 246 */       return Role2FashionDressObserverInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 252 */       return Role2FashionDressObserverInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 258 */       Role2FashionDressObserverInfo.this._xdb_verify_unsafe_();
/* 259 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 265 */       return Role2FashionDressObserverInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 271 */       return Role2FashionDressObserverInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 277 */       return Role2FashionDressObserverInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 283 */       return Role2FashionDressObserverInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 289 */       return Role2FashionDressObserverInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 295 */       return Role2FashionDressObserverInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 301 */       return Role2FashionDressObserverInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Role2FashionDressObserverInfo
/*     */   {
/*     */     private HashMap<Integer, FashionDressExpiredObserver> observer_map;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 313 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 318 */       this.observer_map = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.Role2FashionDressObserverInfo _o1_)
/*     */     {
/* 323 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 329 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 335 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 347 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 353 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2FashionDressObserverInfo copy()
/*     */     {
/* 359 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2FashionDressObserverInfo toData()
/*     */     {
/* 365 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Role2FashionDressObserverInfo toBean()
/*     */     {
/* 370 */       return new Role2FashionDressObserverInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2FashionDressObserverInfo toDataIf()
/*     */     {
/* 376 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Role2FashionDressObserverInfo toBeanIf()
/*     */     {
/* 381 */       return new Role2FashionDressObserverInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 387 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 391 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 395 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 399 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 407 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 411 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<Integer, FashionDressExpiredObserver> getObserver_map()
/*     */     {
/* 418 */       return this.observer_map;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 424 */       if (!(_o1_ instanceof Data)) return false;
/* 425 */       Data _o_ = (Data)_o1_;
/* 426 */       if (!this.observer_map.equals(_o_.observer_map)) return false;
/* 427 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 433 */       int _h_ = 0;
/* 434 */       _h_ += this.observer_map.hashCode();
/* 435 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 441 */       StringBuilder _sb_ = new StringBuilder();
/* 442 */       _sb_.append("(");
/* 443 */       _sb_.append(this.observer_map);
/* 444 */       _sb_.append(")");
/* 445 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2FashionDressObserverInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */