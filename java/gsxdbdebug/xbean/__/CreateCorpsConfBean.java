/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class CreateCorpsConfBean extends XBean implements xbean.CreateCorpsConfBean
/*     */ {
/*     */   private ArrayList<Long> allroles;
/*     */   private ArrayList<Long> acceptroles;
/*     */   private long sessionid;
/*     */   private Octets corpsname;
/*     */   private Octets corpsdeclaration;
/*     */   private int corpsbadge;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  28 */     this.allroles.clear();
/*  29 */     this.acceptroles.clear();
/*  30 */     this.sessionid = 0L;
/*  31 */     this.corpsname = null;
/*  32 */     this.corpsdeclaration = null;
/*  33 */     this.corpsbadge = 0;
/*     */   }
/*     */   
/*     */   CreateCorpsConfBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  38 */     super(_xp_, _vn_);
/*  39 */     this.allroles = new ArrayList();
/*  40 */     this.acceptroles = new ArrayList();
/*  41 */     this.corpsname = null;
/*  42 */     this.corpsdeclaration = null;
/*     */   }
/*     */   
/*     */   public CreateCorpsConfBean()
/*     */   {
/*  47 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CreateCorpsConfBean(CreateCorpsConfBean _o_)
/*     */   {
/*  52 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CreateCorpsConfBean(xbean.CreateCorpsConfBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  57 */     super(_xp_, _vn_);
/*  58 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  70 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  76 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  82 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  88 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CreateCorpsConfBean copy()
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     return new CreateCorpsConfBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CreateCorpsConfBean toData()
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/* 102 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CreateCorpsConfBean toBean()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     return new CreateCorpsConfBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CreateCorpsConfBean toDataIf()
/*     */   {
/* 114 */     _xdb_verify_unsafe_();
/* 115 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CreateCorpsConfBean toBeanIf()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 127 */     _xdb_verify_unsafe_();
/* 128 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getAllroles()
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/* 136 */     return Logs.logList(new LogKey(this, "allroles"), this.allroles);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getAllrolesAsData()
/*     */   {
/* 142 */     _xdb_verify_unsafe_();
/*     */     
/* 144 */     CreateCorpsConfBean _o_ = this;
/* 145 */     List<Long> allroles = new ArrayList();
/* 146 */     allroles.addAll(_o_.allroles);
/* 147 */     return allroles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getAcceptroles()
/*     */   {
/* 154 */     _xdb_verify_unsafe_();
/* 155 */     return Logs.logList(new LogKey(this, "acceptroles"), this.acceptroles);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getAcceptrolesAsData()
/*     */   {
/* 161 */     _xdb_verify_unsafe_();
/*     */     
/* 163 */     CreateCorpsConfBean _o_ = this;
/* 164 */     List<Long> acceptroles = new ArrayList();
/* 165 */     acceptroles.addAll(_o_.acceptroles);
/* 166 */     return acceptroles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionid()
/*     */   {
/* 173 */     _xdb_verify_unsafe_();
/* 174 */     return this.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getCorpsname()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return this.corpsname;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getCorpsdeclaration()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return this.corpsdeclaration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCorpsbadge()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this.corpsbadge;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionid(long _v_)
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     Logs.logIf(new LogKey(this, "sessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 210 */         new xdb.logs.LogLong(this, CreateCorpsConfBean.this.sessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 214 */             CreateCorpsConfBean.this.sessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 218 */     });
/* 219 */     this.sessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCorpsname(Octets _v_)
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     Logs.logIf(new LogKey(this, "corpsname")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 231 */         new xdb.logs.LogObject(this, CreateCorpsConfBean.this.corpsname)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 235 */             CreateCorpsConfBean.this.corpsname = ((Octets)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 239 */     });
/* 240 */     this.corpsname = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCorpsdeclaration(Octets _v_)
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     Logs.logIf(new LogKey(this, "corpsdeclaration")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 252 */         new xdb.logs.LogObject(this, CreateCorpsConfBean.this.corpsdeclaration)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 256 */             CreateCorpsConfBean.this.corpsdeclaration = ((Octets)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 260 */     });
/* 261 */     this.corpsdeclaration = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCorpsbadge(int _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     Logs.logIf(new LogKey(this, "corpsbadge")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogInt(this, CreateCorpsConfBean.this.corpsbadge)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             CreateCorpsConfBean.this.corpsbadge = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.corpsbadge = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     CreateCorpsConfBean _o_ = null;
/* 290 */     if ((_o1_ instanceof CreateCorpsConfBean)) { _o_ = (CreateCorpsConfBean)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (!this.allroles.equals(_o_.allroles)) return false;
/* 294 */     if (!this.acceptroles.equals(_o_.acceptroles)) return false;
/* 295 */     if (this.sessionid != _o_.sessionid) return false;
/* 296 */     if (((null == this.corpsname) && (null != _o_.corpsname)) || ((null != this.corpsname) && (null == _o_.corpsname)) || ((null != this.corpsname) && (null != _o_.corpsname) && (!this.corpsname.equals(_o_.corpsname)))) return false;
/* 297 */     if (((null == this.corpsdeclaration) && (null != _o_.corpsdeclaration)) || ((null != this.corpsdeclaration) && (null == _o_.corpsdeclaration)) || ((null != this.corpsdeclaration) && (null != _o_.corpsdeclaration) && (!this.corpsdeclaration.equals(_o_.corpsdeclaration)))) return false;
/* 298 */     if (this.corpsbadge != _o_.corpsbadge) return false;
/* 299 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 305 */     _xdb_verify_unsafe_();
/* 306 */     int _h_ = 0;
/* 307 */     _h_ += this.allroles.hashCode();
/* 308 */     _h_ += this.acceptroles.hashCode();
/* 309 */     _h_ = (int)(_h_ + this.sessionid);
/* 310 */     _h_ += (this.corpsname == null ? 0 : this.corpsname.hashCode());
/* 311 */     _h_ += (this.corpsdeclaration == null ? 0 : this.corpsdeclaration.hashCode());
/* 312 */     _h_ += this.corpsbadge;
/* 313 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 319 */     _xdb_verify_unsafe_();
/* 320 */     StringBuilder _sb_ = new StringBuilder();
/* 321 */     _sb_.append("(");
/* 322 */     _sb_.append(this.allroles);
/* 323 */     _sb_.append(",");
/* 324 */     _sb_.append(this.acceptroles);
/* 325 */     _sb_.append(",");
/* 326 */     _sb_.append(this.sessionid);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.corpsname);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.corpsdeclaration);
/* 331 */     _sb_.append(",");
/* 332 */     _sb_.append(this.corpsbadge);
/* 333 */     _sb_.append(")");
/* 334 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 340 */     ListenableBean lb = new ListenableBean();
/* 341 */     lb.add(new ListenableChanged().setVarName("allroles"));
/* 342 */     lb.add(new ListenableChanged().setVarName("acceptroles"));
/* 343 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/* 344 */     lb.add(new ListenableChanged().setVarName("corpsname"));
/* 345 */     lb.add(new ListenableChanged().setVarName("corpsdeclaration"));
/* 346 */     lb.add(new ListenableChanged().setVarName("corpsbadge"));
/* 347 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CreateCorpsConfBean {
/*     */     private Const() {}
/*     */     
/*     */     CreateCorpsConfBean nThis() {
/* 354 */       return CreateCorpsConfBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 360 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CreateCorpsConfBean copy()
/*     */     {
/* 366 */       return CreateCorpsConfBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CreateCorpsConfBean toData()
/*     */     {
/* 372 */       return CreateCorpsConfBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CreateCorpsConfBean toBean()
/*     */     {
/* 377 */       return CreateCorpsConfBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CreateCorpsConfBean toDataIf()
/*     */     {
/* 383 */       return CreateCorpsConfBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CreateCorpsConfBean toBeanIf()
/*     */     {
/* 388 */       return CreateCorpsConfBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllroles()
/*     */     {
/* 395 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 396 */       return xdb.Consts.constList(CreateCorpsConfBean.this.allroles);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getAllrolesAsData()
/*     */     {
/* 402 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/*     */       
/* 404 */       CreateCorpsConfBean _o_ = CreateCorpsConfBean.this;
/* 405 */       List<Long> allroles = new ArrayList();
/* 406 */       allroles.addAll(_o_.allroles);
/* 407 */       return allroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAcceptroles()
/*     */     {
/* 414 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 415 */       return xdb.Consts.constList(CreateCorpsConfBean.this.acceptroles);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getAcceptrolesAsData()
/*     */     {
/* 421 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/*     */       
/* 423 */       CreateCorpsConfBean _o_ = CreateCorpsConfBean.this;
/* 424 */       List<Long> acceptroles = new ArrayList();
/* 425 */       acceptroles.addAll(_o_.acceptroles);
/* 426 */       return acceptroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 433 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 434 */       return CreateCorpsConfBean.this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getCorpsname()
/*     */     {
/* 441 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 442 */       return CreateCorpsConfBean.this.corpsname;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getCorpsdeclaration()
/*     */     {
/* 449 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 450 */       return CreateCorpsConfBean.this.corpsdeclaration;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCorpsbadge()
/*     */     {
/* 457 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 458 */       return CreateCorpsConfBean.this.corpsbadge;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 465 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 466 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorpsname(Octets _v_)
/*     */     {
/* 473 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 474 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorpsdeclaration(Octets _v_)
/*     */     {
/* 481 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 482 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorpsbadge(int _v_)
/*     */     {
/* 489 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 490 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 496 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 497 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 503 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 504 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 510 */       return CreateCorpsConfBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 516 */       return CreateCorpsConfBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 522 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 523 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 529 */       return CreateCorpsConfBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 535 */       return CreateCorpsConfBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 541 */       CreateCorpsConfBean.this._xdb_verify_unsafe_();
/* 542 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 548 */       return CreateCorpsConfBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 554 */       return CreateCorpsConfBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 560 */       return CreateCorpsConfBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 566 */       return CreateCorpsConfBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 572 */       return CreateCorpsConfBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 578 */       return CreateCorpsConfBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 584 */       return CreateCorpsConfBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CreateCorpsConfBean
/*     */   {
/*     */     private ArrayList<Long> allroles;
/*     */     
/*     */     private ArrayList<Long> acceptroles;
/*     */     
/*     */     private long sessionid;
/*     */     
/*     */     private Octets corpsname;
/*     */     
/*     */     private Octets corpsdeclaration;
/*     */     
/*     */     private int corpsbadge;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 606 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 611 */       this.allroles = new ArrayList();
/* 612 */       this.acceptroles = new ArrayList();
/* 613 */       this.corpsname = null;
/* 614 */       this.corpsdeclaration = null;
/*     */     }
/*     */     
/*     */     Data(xbean.CreateCorpsConfBean _o1_)
/*     */     {
/* 619 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 631 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 643 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 649 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CreateCorpsConfBean copy()
/*     */     {
/* 655 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CreateCorpsConfBean toData()
/*     */     {
/* 661 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CreateCorpsConfBean toBean()
/*     */     {
/* 666 */       return new CreateCorpsConfBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CreateCorpsConfBean toDataIf()
/*     */     {
/* 672 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CreateCorpsConfBean toBeanIf()
/*     */     {
/* 677 */       return new CreateCorpsConfBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 683 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 687 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 691 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 695 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 699 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 703 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 707 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllroles()
/*     */     {
/* 714 */       return this.allroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAllrolesAsData()
/*     */     {
/* 721 */       return this.allroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAcceptroles()
/*     */     {
/* 728 */       return this.acceptroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getAcceptrolesAsData()
/*     */     {
/* 735 */       return this.acceptroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 742 */       return this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getCorpsname()
/*     */     {
/* 749 */       return this.corpsname;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getCorpsdeclaration()
/*     */     {
/* 756 */       return this.corpsdeclaration;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCorpsbadge()
/*     */     {
/* 763 */       return this.corpsbadge;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 770 */       this.sessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorpsname(Octets _v_)
/*     */     {
/* 777 */       this.corpsname = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorpsdeclaration(Octets _v_)
/*     */     {
/* 784 */       this.corpsdeclaration = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorpsbadge(int _v_)
/*     */     {
/* 791 */       this.corpsbadge = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 797 */       if (!(_o1_ instanceof Data)) return false;
/* 798 */       Data _o_ = (Data)_o1_;
/* 799 */       if (!this.allroles.equals(_o_.allroles)) return false;
/* 800 */       if (!this.acceptroles.equals(_o_.acceptroles)) return false;
/* 801 */       if (this.sessionid != _o_.sessionid) return false;
/* 802 */       if (((null == this.corpsname) && (null != _o_.corpsname)) || ((null != this.corpsname) && (null == _o_.corpsname)) || ((null != this.corpsname) && (null != _o_.corpsname) && (!this.corpsname.equals(_o_.corpsname)))) return false;
/* 803 */       if (((null == this.corpsdeclaration) && (null != _o_.corpsdeclaration)) || ((null != this.corpsdeclaration) && (null == _o_.corpsdeclaration)) || ((null != this.corpsdeclaration) && (null != _o_.corpsdeclaration) && (!this.corpsdeclaration.equals(_o_.corpsdeclaration)))) return false;
/* 804 */       if (this.corpsbadge != _o_.corpsbadge) return false;
/* 805 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 811 */       int _h_ = 0;
/* 812 */       _h_ += this.allroles.hashCode();
/* 813 */       _h_ += this.acceptroles.hashCode();
/* 814 */       _h_ = (int)(_h_ + this.sessionid);
/* 815 */       _h_ += (this.corpsname == null ? 0 : this.corpsname.hashCode());
/* 816 */       _h_ += (this.corpsdeclaration == null ? 0 : this.corpsdeclaration.hashCode());
/* 817 */       _h_ += this.corpsbadge;
/* 818 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 824 */       StringBuilder _sb_ = new StringBuilder();
/* 825 */       _sb_.append("(");
/* 826 */       _sb_.append(this.allroles);
/* 827 */       _sb_.append(",");
/* 828 */       _sb_.append(this.acceptroles);
/* 829 */       _sb_.append(",");
/* 830 */       _sb_.append(this.sessionid);
/* 831 */       _sb_.append(",");
/* 832 */       _sb_.append(this.corpsname);
/* 833 */       _sb_.append(",");
/* 834 */       _sb_.append(this.corpsdeclaration);
/* 835 */       _sb_.append(",");
/* 836 */       _sb_.append(this.corpsbadge);
/* 837 */       _sb_.append(")");
/* 838 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CreateCorpsConfBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */