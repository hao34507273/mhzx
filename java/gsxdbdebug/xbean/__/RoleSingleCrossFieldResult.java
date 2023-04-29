/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public final class RoleSingleCrossFieldResult extends XBean implements xbean.RoleSingleCrossFieldResult
/*     */ {
/*     */   private ArrayList<Protocol> result;
/*     */   private long session_id;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.result.clear();
/*  21 */     this.session_id = -1L;
/*     */   }
/*     */   
/*     */   RoleSingleCrossFieldResult(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.result = new ArrayList();
/*  28 */     this.session_id = -1L;
/*     */   }
/*     */   
/*     */   public RoleSingleCrossFieldResult()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleSingleCrossFieldResult(RoleSingleCrossFieldResult _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleSingleCrossFieldResult(xbean.RoleSingleCrossFieldResult _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  50 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  56 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  62 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  68 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  74 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleSingleCrossFieldResult copy()
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     return new RoleSingleCrossFieldResult(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleSingleCrossFieldResult toData()
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleSingleCrossFieldResult toBean()
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*  94 */     return new RoleSingleCrossFieldResult(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleSingleCrossFieldResult toDataIf()
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleSingleCrossFieldResult toBeanIf()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.List<Protocol> getResult()
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/* 122 */     return xdb.Logs.logList(new LogKey(this, "result"), this.result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSession_id()
/*     */   {
/* 129 */     _xdb_verify_unsafe_();
/* 130 */     return this.session_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSession_id(long _v_)
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     xdb.Logs.logIf(new LogKey(this, "session_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 142 */         new xdb.logs.LogLong(this, RoleSingleCrossFieldResult.this.session_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 146 */             RoleSingleCrossFieldResult.this.session_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 150 */     });
/* 151 */     this.session_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     RoleSingleCrossFieldResult _o_ = null;
/* 159 */     if ((_o1_ instanceof RoleSingleCrossFieldResult)) { _o_ = (RoleSingleCrossFieldResult)_o1_;
/* 160 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 161 */       return false;
/* 162 */     if (!this.result.equals(_o_.result)) return false;
/* 163 */     if (this.session_id != _o_.session_id) return false;
/* 164 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     int _h_ = 0;
/* 172 */     _h_ += this.result.hashCode();
/* 173 */     _h_ = (int)(_h_ + this.session_id);
/* 174 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 180 */     _xdb_verify_unsafe_();
/* 181 */     StringBuilder _sb_ = new StringBuilder();
/* 182 */     _sb_.append("(");
/* 183 */     _sb_.append(this.result);
/* 184 */     _sb_.append(",");
/* 185 */     _sb_.append(this.session_id);
/* 186 */     _sb_.append(")");
/* 187 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 193 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 194 */     lb.add(new xdb.logs.ListenableChanged().setVarName("result"));
/* 195 */     lb.add(new xdb.logs.ListenableChanged().setVarName("session_id"));
/* 196 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleSingleCrossFieldResult {
/*     */     private Const() {}
/*     */     
/*     */     RoleSingleCrossFieldResult nThis() {
/* 203 */       return RoleSingleCrossFieldResult.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 209 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldResult copy()
/*     */     {
/* 215 */       return RoleSingleCrossFieldResult.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldResult toData()
/*     */     {
/* 221 */       return RoleSingleCrossFieldResult.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldResult toBean()
/*     */     {
/* 226 */       return RoleSingleCrossFieldResult.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldResult toDataIf()
/*     */     {
/* 232 */       return RoleSingleCrossFieldResult.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldResult toBeanIf()
/*     */     {
/* 237 */       return RoleSingleCrossFieldResult.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<Protocol> getResult()
/*     */     {
/* 244 */       RoleSingleCrossFieldResult.this._xdb_verify_unsafe_();
/* 245 */       return xdb.Consts.constList(RoleSingleCrossFieldResult.this.result);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSession_id()
/*     */     {
/* 252 */       RoleSingleCrossFieldResult.this._xdb_verify_unsafe_();
/* 253 */       return RoleSingleCrossFieldResult.this.session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSession_id(long _v_)
/*     */     {
/* 260 */       RoleSingleCrossFieldResult.this._xdb_verify_unsafe_();
/* 261 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 267 */       RoleSingleCrossFieldResult.this._xdb_verify_unsafe_();
/* 268 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 274 */       RoleSingleCrossFieldResult.this._xdb_verify_unsafe_();
/* 275 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 281 */       return RoleSingleCrossFieldResult.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 287 */       return RoleSingleCrossFieldResult.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 293 */       RoleSingleCrossFieldResult.this._xdb_verify_unsafe_();
/* 294 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 300 */       return RoleSingleCrossFieldResult.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 306 */       return RoleSingleCrossFieldResult.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 312 */       RoleSingleCrossFieldResult.this._xdb_verify_unsafe_();
/* 313 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 319 */       return RoleSingleCrossFieldResult.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 325 */       return RoleSingleCrossFieldResult.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 331 */       return RoleSingleCrossFieldResult.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 337 */       return RoleSingleCrossFieldResult.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 343 */       return RoleSingleCrossFieldResult.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 349 */       return RoleSingleCrossFieldResult.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 355 */       return RoleSingleCrossFieldResult.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleSingleCrossFieldResult
/*     */   {
/*     */     private ArrayList<Protocol> result;
/*     */     
/*     */     private long session_id;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 369 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 374 */       this.result = new ArrayList();
/* 375 */       this.session_id = -1L;
/*     */     }
/*     */     
/*     */     Data(xbean.RoleSingleCrossFieldResult _o1_)
/*     */     {
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 386 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 392 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 398 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 404 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 410 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldResult copy()
/*     */     {
/* 416 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldResult toData()
/*     */     {
/* 422 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldResult toBean()
/*     */     {
/* 427 */       return new RoleSingleCrossFieldResult(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldResult toDataIf()
/*     */     {
/* 433 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldResult toBeanIf()
/*     */     {
/* 438 */       return new RoleSingleCrossFieldResult(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 448 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 452 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 456 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 460 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 464 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 468 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<Protocol> getResult()
/*     */     {
/* 475 */       return this.result;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSession_id()
/*     */     {
/* 482 */       return this.session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSession_id(long _v_)
/*     */     {
/* 489 */       this.session_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 495 */       if (!(_o1_ instanceof Data)) return false;
/* 496 */       Data _o_ = (Data)_o1_;
/* 497 */       if (!this.result.equals(_o_.result)) return false;
/* 498 */       if (this.session_id != _o_.session_id) return false;
/* 499 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 505 */       int _h_ = 0;
/* 506 */       _h_ += this.result.hashCode();
/* 507 */       _h_ = (int)(_h_ + this.session_id);
/* 508 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 514 */       StringBuilder _sb_ = new StringBuilder();
/* 515 */       _sb_.append("(");
/* 516 */       _sb_.append(this.result);
/* 517 */       _sb_.append(",");
/* 518 */       _sb_.append(this.session_id);
/* 519 */       _sb_.append(")");
/* 520 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleSingleCrossFieldResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */