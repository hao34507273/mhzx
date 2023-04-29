/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class AppellationInfo extends XBean implements xbean.AppellationInfo
/*     */ {
/*     */   private int appellationid;
/*     */   private int ispropertyactive;
/*     */   private ArrayList<String> appargs;
/*     */   private long timeout;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.appellationid = 0;
/*  25 */     this.ispropertyactive = 0;
/*  26 */     this.appargs.clear();
/*  27 */     this.timeout = 0L;
/*     */   }
/*     */   
/*     */   AppellationInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.appargs = new ArrayList();
/*  34 */     this.timeout = 0L;
/*     */   }
/*     */   
/*     */   public AppellationInfo()
/*     */   {
/*  39 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public AppellationInfo(AppellationInfo _o_)
/*     */   {
/*  44 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   AppellationInfo(xbean.AppellationInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  49 */     super(_xp_, _vn_);
/*  50 */     if ((_o1_ instanceof AppellationInfo)) { assign((AppellationInfo)_o1_);
/*  51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  53 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(AppellationInfo _o_) {
/*  58 */     _o_._xdb_verify_unsafe_();
/*  59 */     this.appellationid = _o_.appellationid;
/*  60 */     this.ispropertyactive = _o_.ispropertyactive;
/*  61 */     this.appargs = new ArrayList();
/*  62 */     this.appargs.addAll(_o_.appargs);
/*  63 */     this.timeout = _o_.timeout;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  68 */     this.appellationid = _o_.appellationid;
/*  69 */     this.ispropertyactive = _o_.ispropertyactive;
/*  70 */     this.appargs = new ArrayList();
/*  71 */     this.appargs.addAll(_o_.appargs);
/*  72 */     this.timeout = _o_.timeout;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  78 */     _xdb_verify_unsafe_();
/*  79 */     _os_.marshal(this.appellationid);
/*  80 */     _os_.marshal(this.ispropertyactive);
/*  81 */     _os_.compact_uint32(this.appargs.size());
/*  82 */     for (String _v_ : this.appargs)
/*     */     {
/*  84 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  86 */     _os_.marshal(this.timeout);
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*  94 */     this.appellationid = _os_.unmarshal_int();
/*  95 */     this.ispropertyactive = _os_.unmarshal_int();
/*  96 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  98 */       String _v_ = "";
/*  99 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/* 100 */       this.appargs.add(_v_);
/*     */     }
/* 102 */     this.timeout = _os_.unmarshal_long();
/* 103 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/* 110 */     int _size_ = 0;
/* 111 */     _size_ += CodedOutputStream.computeInt32Size(1, this.appellationid);
/* 112 */     _size_ += CodedOutputStream.computeInt32Size(2, this.ispropertyactive);
/* 113 */     for (String _v_ : this.appargs)
/*     */     {
/*     */       try
/*     */       {
/* 117 */         _size_ += CodedOutputStream.computeBytesSize(3, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 121 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/*     */     }
/* 124 */     _size_ += CodedOutputStream.computeInt64Size(4, this.timeout);
/* 125 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 131 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 134 */       _output_.writeInt32(1, this.appellationid);
/* 135 */       _output_.writeInt32(2, this.ispropertyactive);
/* 136 */       for (String _v_ : this.appargs)
/*     */       {
/* 138 */         _output_.writeBytes(3, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */       }
/* 140 */       _output_.writeInt64(4, this.timeout);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 144 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 146 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 152 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 155 */       boolean done = false;
/* 156 */       while (!done)
/*     */       {
/* 158 */         int tag = _input_.readTag();
/* 159 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 163 */           done = true;
/* 164 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 168 */           this.appellationid = _input_.readInt32();
/* 169 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 173 */           this.ispropertyactive = _input_.readInt32();
/* 174 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 178 */           String _v_ = "";
/* 179 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/* 180 */           this.appargs.add(_v_);
/* 181 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 185 */           this.timeout = _input_.readInt64();
/* 186 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 190 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 192 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 201 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 205 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 207 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AppellationInfo copy()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new AppellationInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AppellationInfo toData()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AppellationInfo toBean()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new AppellationInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AppellationInfo toDataIf()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AppellationInfo toBeanIf()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAppellationid()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return this.appellationid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIspropertyactive()
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     return this.ispropertyactive;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<String> getAppargs()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     return xdb.Logs.logList(new LogKey(this, "appargs"), this.appargs);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<String> getAppargsAsData()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/*     */     
/* 279 */     AppellationInfo _o_ = this;
/* 280 */     List<String> appargs = new ArrayList();
/* 281 */     appargs.addAll(_o_.appargs);
/* 282 */     return appargs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTimeout()
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     return this.timeout;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAppellationid(int _v_)
/*     */   {
/* 297 */     _xdb_verify_unsafe_();
/* 298 */     xdb.Logs.logIf(new LogKey(this, "appellationid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 302 */         new xdb.logs.LogInt(this, AppellationInfo.this.appellationid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 306 */             AppellationInfo.this.appellationid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 310 */     });
/* 311 */     this.appellationid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIspropertyactive(int _v_)
/*     */   {
/* 318 */     _xdb_verify_unsafe_();
/* 319 */     xdb.Logs.logIf(new LogKey(this, "ispropertyactive")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 323 */         new xdb.logs.LogInt(this, AppellationInfo.this.ispropertyactive)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 327 */             AppellationInfo.this.ispropertyactive = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 331 */     });
/* 332 */     this.ispropertyactive = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTimeout(long _v_)
/*     */   {
/* 339 */     _xdb_verify_unsafe_();
/* 340 */     xdb.Logs.logIf(new LogKey(this, "timeout")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 344 */         new xdb.logs.LogLong(this, AppellationInfo.this.timeout)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 348 */             AppellationInfo.this.timeout = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 352 */     });
/* 353 */     this.timeout = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 359 */     _xdb_verify_unsafe_();
/* 360 */     AppellationInfo _o_ = null;
/* 361 */     if ((_o1_ instanceof AppellationInfo)) { _o_ = (AppellationInfo)_o1_;
/* 362 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 363 */       return false;
/* 364 */     if (this.appellationid != _o_.appellationid) return false;
/* 365 */     if (this.ispropertyactive != _o_.ispropertyactive) return false;
/* 366 */     if (!this.appargs.equals(_o_.appargs)) return false;
/* 367 */     if (this.timeout != _o_.timeout) return false;
/* 368 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 374 */     _xdb_verify_unsafe_();
/* 375 */     int _h_ = 0;
/* 376 */     _h_ += this.appellationid;
/* 377 */     _h_ += this.ispropertyactive;
/* 378 */     _h_ += this.appargs.hashCode();
/* 379 */     _h_ = (int)(_h_ + this.timeout);
/* 380 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 386 */     _xdb_verify_unsafe_();
/* 387 */     StringBuilder _sb_ = new StringBuilder();
/* 388 */     _sb_.append("(");
/* 389 */     _sb_.append(this.appellationid);
/* 390 */     _sb_.append(",");
/* 391 */     _sb_.append(this.ispropertyactive);
/* 392 */     _sb_.append(",");
/* 393 */     _sb_.append(this.appargs);
/* 394 */     _sb_.append(",");
/* 395 */     _sb_.append(this.timeout);
/* 396 */     _sb_.append(")");
/* 397 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 403 */     ListenableBean lb = new ListenableBean();
/* 404 */     lb.add(new ListenableChanged().setVarName("appellationid"));
/* 405 */     lb.add(new ListenableChanged().setVarName("ispropertyactive"));
/* 406 */     lb.add(new ListenableChanged().setVarName("appargs"));
/* 407 */     lb.add(new ListenableChanged().setVarName("timeout"));
/* 408 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.AppellationInfo {
/*     */     private Const() {}
/*     */     
/*     */     AppellationInfo nThis() {
/* 415 */       return AppellationInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AppellationInfo copy()
/*     */     {
/* 427 */       return AppellationInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AppellationInfo toData()
/*     */     {
/* 433 */       return AppellationInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.AppellationInfo toBean()
/*     */     {
/* 438 */       return AppellationInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AppellationInfo toDataIf()
/*     */     {
/* 444 */       return AppellationInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.AppellationInfo toBeanIf()
/*     */     {
/* 449 */       return AppellationInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAppellationid()
/*     */     {
/* 456 */       AppellationInfo.this._xdb_verify_unsafe_();
/* 457 */       return AppellationInfo.this.appellationid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIspropertyactive()
/*     */     {
/* 464 */       AppellationInfo.this._xdb_verify_unsafe_();
/* 465 */       return AppellationInfo.this.ispropertyactive;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getAppargs()
/*     */     {
/* 472 */       AppellationInfo.this._xdb_verify_unsafe_();
/* 473 */       return xdb.Consts.constList(AppellationInfo.this.appargs);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<String> getAppargsAsData()
/*     */     {
/* 479 */       AppellationInfo.this._xdb_verify_unsafe_();
/*     */       
/* 481 */       AppellationInfo _o_ = AppellationInfo.this;
/* 482 */       List<String> appargs = new ArrayList();
/* 483 */       appargs.addAll(_o_.appargs);
/* 484 */       return appargs;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimeout()
/*     */     {
/* 491 */       AppellationInfo.this._xdb_verify_unsafe_();
/* 492 */       return AppellationInfo.this.timeout;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAppellationid(int _v_)
/*     */     {
/* 499 */       AppellationInfo.this._xdb_verify_unsafe_();
/* 500 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIspropertyactive(int _v_)
/*     */     {
/* 507 */       AppellationInfo.this._xdb_verify_unsafe_();
/* 508 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimeout(long _v_)
/*     */     {
/* 515 */       AppellationInfo.this._xdb_verify_unsafe_();
/* 516 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 522 */       AppellationInfo.this._xdb_verify_unsafe_();
/* 523 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 529 */       AppellationInfo.this._xdb_verify_unsafe_();
/* 530 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 536 */       return AppellationInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 542 */       return AppellationInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 548 */       AppellationInfo.this._xdb_verify_unsafe_();
/* 549 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 555 */       return AppellationInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 561 */       return AppellationInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 567 */       AppellationInfo.this._xdb_verify_unsafe_();
/* 568 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 574 */       return AppellationInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 580 */       return AppellationInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 586 */       return AppellationInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 592 */       return AppellationInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 598 */       return AppellationInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 604 */       return AppellationInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 610 */       return AppellationInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.AppellationInfo
/*     */   {
/*     */     private int appellationid;
/*     */     
/*     */     private int ispropertyactive;
/*     */     
/*     */     private ArrayList<String> appargs;
/*     */     
/*     */     private long timeout;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 628 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 633 */       this.appargs = new ArrayList();
/* 634 */       this.timeout = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.AppellationInfo _o1_)
/*     */     {
/* 639 */       if ((_o1_ instanceof AppellationInfo)) { assign((AppellationInfo)_o1_);
/* 640 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 641 */       } else if ((_o1_ instanceof AppellationInfo.Const)) assign(((AppellationInfo.Const)_o1_).nThis()); else {
/* 642 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(AppellationInfo _o_) {
/* 647 */       this.appellationid = _o_.appellationid;
/* 648 */       this.ispropertyactive = _o_.ispropertyactive;
/* 649 */       this.appargs = new ArrayList();
/* 650 */       this.appargs.addAll(_o_.appargs);
/* 651 */       this.timeout = _o_.timeout;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 656 */       this.appellationid = _o_.appellationid;
/* 657 */       this.ispropertyactive = _o_.ispropertyactive;
/* 658 */       this.appargs = new ArrayList();
/* 659 */       this.appargs.addAll(_o_.appargs);
/* 660 */       this.timeout = _o_.timeout;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 666 */       _os_.marshal(this.appellationid);
/* 667 */       _os_.marshal(this.ispropertyactive);
/* 668 */       _os_.compact_uint32(this.appargs.size());
/* 669 */       for (String _v_ : this.appargs)
/*     */       {
/* 671 */         _os_.marshal(_v_, "UTF-16LE");
/*     */       }
/* 673 */       _os_.marshal(this.timeout);
/* 674 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 680 */       this.appellationid = _os_.unmarshal_int();
/* 681 */       this.ispropertyactive = _os_.unmarshal_int();
/* 682 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 684 */         String _v_ = "";
/* 685 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/* 686 */         this.appargs.add(_v_);
/*     */       }
/* 688 */       this.timeout = _os_.unmarshal_long();
/* 689 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 695 */       int _size_ = 0;
/* 696 */       _size_ += CodedOutputStream.computeInt32Size(1, this.appellationid);
/* 697 */       _size_ += CodedOutputStream.computeInt32Size(2, this.ispropertyactive);
/* 698 */       for (String _v_ : this.appargs)
/*     */       {
/*     */         try
/*     */         {
/* 702 */           _size_ += CodedOutputStream.computeBytesSize(3, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */         }
/*     */         catch (java.io.UnsupportedEncodingException e)
/*     */         {
/* 706 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*     */         }
/*     */       }
/* 709 */       _size_ += CodedOutputStream.computeInt64Size(4, this.timeout);
/* 710 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 718 */         _output_.writeInt32(1, this.appellationid);
/* 719 */         _output_.writeInt32(2, this.ispropertyactive);
/* 720 */         for (String _v_ : this.appargs)
/*     */         {
/* 722 */           _output_.writeBytes(3, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */         }
/* 724 */         _output_.writeInt64(4, this.timeout);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 728 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 730 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 738 */         boolean done = false;
/* 739 */         while (!done)
/*     */         {
/* 741 */           int tag = _input_.readTag();
/* 742 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 746 */             done = true;
/* 747 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 751 */             this.appellationid = _input_.readInt32();
/* 752 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 756 */             this.ispropertyactive = _input_.readInt32();
/* 757 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 761 */             String _v_ = "";
/* 762 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 763 */             this.appargs.add(_v_);
/* 764 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 768 */             this.timeout = _input_.readInt64();
/* 769 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 773 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 775 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 784 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 788 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 790 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AppellationInfo copy()
/*     */     {
/* 796 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AppellationInfo toData()
/*     */     {
/* 802 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.AppellationInfo toBean()
/*     */     {
/* 807 */       return new AppellationInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AppellationInfo toDataIf()
/*     */     {
/* 813 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.AppellationInfo toBeanIf()
/*     */     {
/* 818 */       return new AppellationInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 824 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 828 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 832 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 836 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 840 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 844 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 848 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAppellationid()
/*     */     {
/* 855 */       return this.appellationid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIspropertyactive()
/*     */     {
/* 862 */       return this.ispropertyactive;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getAppargs()
/*     */     {
/* 869 */       return this.appargs;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getAppargsAsData()
/*     */     {
/* 876 */       return this.appargs;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimeout()
/*     */     {
/* 883 */       return this.timeout;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAppellationid(int _v_)
/*     */     {
/* 890 */       this.appellationid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIspropertyactive(int _v_)
/*     */     {
/* 897 */       this.ispropertyactive = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimeout(long _v_)
/*     */     {
/* 904 */       this.timeout = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 910 */       if (!(_o1_ instanceof Data)) return false;
/* 911 */       Data _o_ = (Data)_o1_;
/* 912 */       if (this.appellationid != _o_.appellationid) return false;
/* 913 */       if (this.ispropertyactive != _o_.ispropertyactive) return false;
/* 914 */       if (!this.appargs.equals(_o_.appargs)) return false;
/* 915 */       if (this.timeout != _o_.timeout) return false;
/* 916 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 922 */       int _h_ = 0;
/* 923 */       _h_ += this.appellationid;
/* 924 */       _h_ += this.ispropertyactive;
/* 925 */       _h_ += this.appargs.hashCode();
/* 926 */       _h_ = (int)(_h_ + this.timeout);
/* 927 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 933 */       StringBuilder _sb_ = new StringBuilder();
/* 934 */       _sb_.append("(");
/* 935 */       _sb_.append(this.appellationid);
/* 936 */       _sb_.append(",");
/* 937 */       _sb_.append(this.ispropertyactive);
/* 938 */       _sb_.append(",");
/* 939 */       _sb_.append(this.appargs);
/* 940 */       _sb_.append(",");
/* 941 */       _sb_.append(this.timeout);
/* 942 */       _sb_.append(")");
/* 943 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AppellationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */