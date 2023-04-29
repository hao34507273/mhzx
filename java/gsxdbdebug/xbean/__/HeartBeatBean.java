/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.online.main.HeartbeatLogObserver;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class HeartBeatBean extends XBean implements xbean.HeartBeatBean
/*     */ {
/*     */   private HeartbeatLogObserver heartbeatobserver;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.heartbeatobserver = null;
/*     */   }
/*     */   
/*     */   HeartBeatBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.heartbeatobserver = null;
/*     */   }
/*     */   
/*     */   public HeartBeatBean()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public HeartBeatBean(HeartBeatBean _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   HeartBeatBean(xbean.HeartBeatBean _o1_, XBean _xp_, String _vn_)
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
/*     */   public xbean.HeartBeatBean copy()
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     return new HeartBeatBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HeartBeatBean toData()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HeartBeatBean toBean()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     return new HeartBeatBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HeartBeatBean toDataIf()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HeartBeatBean toBeanIf()
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
/*     */   public HeartbeatLogObserver getHeartbeatobserver()
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/* 118 */     return this.heartbeatobserver;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHeartbeatobserver(HeartbeatLogObserver _v_)
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     xdb.Logs.logIf(new LogKey(this, "heartbeatobserver")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 130 */         new xdb.logs.LogObject(this, HeartBeatBean.this.heartbeatobserver)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 134 */             HeartBeatBean.this.heartbeatobserver = ((HeartbeatLogObserver)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 138 */     });
/* 139 */     this.heartbeatobserver = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/* 146 */     HeartBeatBean _o_ = null;
/* 147 */     if ((_o1_ instanceof HeartBeatBean)) { _o_ = (HeartBeatBean)_o1_;
/* 148 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 149 */       return false;
/* 150 */     if (((null == this.heartbeatobserver) && (null != _o_.heartbeatobserver)) || ((null != this.heartbeatobserver) && (null == _o_.heartbeatobserver)) || ((null != this.heartbeatobserver) && (null != _o_.heartbeatobserver) && (!this.heartbeatobserver.equals(_o_.heartbeatobserver)))) return false;
/* 151 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     int _h_ = 0;
/* 159 */     _h_ += (this.heartbeatobserver == null ? 0 : this.heartbeatobserver.hashCode());
/* 160 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     StringBuilder _sb_ = new StringBuilder();
/* 168 */     _sb_.append("(");
/* 169 */     _sb_.append(this.heartbeatobserver);
/* 170 */     _sb_.append(")");
/* 171 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 177 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 178 */     lb.add(new xdb.logs.ListenableChanged().setVarName("heartbeatobserver"));
/* 179 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.HeartBeatBean {
/*     */     private Const() {}
/*     */     
/*     */     HeartBeatBean nThis() {
/* 186 */       return HeartBeatBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 192 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HeartBeatBean copy()
/*     */     {
/* 198 */       return HeartBeatBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HeartBeatBean toData()
/*     */     {
/* 204 */       return HeartBeatBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.HeartBeatBean toBean()
/*     */     {
/* 209 */       return HeartBeatBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HeartBeatBean toDataIf()
/*     */     {
/* 215 */       return HeartBeatBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.HeartBeatBean toBeanIf()
/*     */     {
/* 220 */       return HeartBeatBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public HeartbeatLogObserver getHeartbeatobserver()
/*     */     {
/* 227 */       HeartBeatBean.this._xdb_verify_unsafe_();
/* 228 */       return HeartBeatBean.this.heartbeatobserver;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHeartbeatobserver(HeartbeatLogObserver _v_)
/*     */     {
/* 235 */       HeartBeatBean.this._xdb_verify_unsafe_();
/* 236 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 242 */       HeartBeatBean.this._xdb_verify_unsafe_();
/* 243 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 249 */       HeartBeatBean.this._xdb_verify_unsafe_();
/* 250 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 256 */       return HeartBeatBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 262 */       return HeartBeatBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 268 */       HeartBeatBean.this._xdb_verify_unsafe_();
/* 269 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 275 */       return HeartBeatBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 281 */       return HeartBeatBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 287 */       HeartBeatBean.this._xdb_verify_unsafe_();
/* 288 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 294 */       return HeartBeatBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 300 */       return HeartBeatBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 306 */       return HeartBeatBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 312 */       return HeartBeatBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 318 */       return HeartBeatBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 324 */       return HeartBeatBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 330 */       return HeartBeatBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.HeartBeatBean
/*     */   {
/*     */     private HeartbeatLogObserver heartbeatobserver;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 342 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 347 */       this.heartbeatobserver = null;
/*     */     }
/*     */     
/*     */     Data(xbean.HeartBeatBean _o1_)
/*     */     {
/* 352 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 364 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 370 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 376 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 382 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HeartBeatBean copy()
/*     */     {
/* 388 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HeartBeatBean toData()
/*     */     {
/* 394 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.HeartBeatBean toBean()
/*     */     {
/* 399 */       return new HeartBeatBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HeartBeatBean toDataIf()
/*     */     {
/* 405 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.HeartBeatBean toBeanIf()
/*     */     {
/* 410 */       return new HeartBeatBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 416 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 420 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 424 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 428 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 436 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 440 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public HeartbeatLogObserver getHeartbeatobserver()
/*     */     {
/* 447 */       return this.heartbeatobserver;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHeartbeatobserver(HeartbeatLogObserver _v_)
/*     */     {
/* 454 */       this.heartbeatobserver = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 460 */       if (!(_o1_ instanceof Data)) return false;
/* 461 */       Data _o_ = (Data)_o1_;
/* 462 */       if (((null == this.heartbeatobserver) && (null != _o_.heartbeatobserver)) || ((null != this.heartbeatobserver) && (null == _o_.heartbeatobserver)) || ((null != this.heartbeatobserver) && (null != _o_.heartbeatobserver) && (!this.heartbeatobserver.equals(_o_.heartbeatobserver)))) return false;
/* 463 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 469 */       int _h_ = 0;
/* 470 */       _h_ += (this.heartbeatobserver == null ? 0 : this.heartbeatobserver.hashCode());
/* 471 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 477 */       StringBuilder _sb_ = new StringBuilder();
/* 478 */       _sb_.append("(");
/* 479 */       _sb_.append(this.heartbeatobserver);
/* 480 */       _sb_.append(")");
/* 481 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\HeartBeatBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */