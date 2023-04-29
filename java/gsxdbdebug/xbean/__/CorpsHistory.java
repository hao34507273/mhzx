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
/*     */ public final class CorpsHistory extends XBean implements xbean.CorpsHistory
/*     */ {
/*     */   private int recordtime;
/*     */   private int historytype;
/*     */   private ArrayList<String> parameters;
/*     */   private int historyid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.recordtime = 0;
/*  25 */     this.historytype = 0;
/*  26 */     this.parameters.clear();
/*  27 */     this.historyid = 0;
/*     */   }
/*     */   
/*     */   CorpsHistory(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.parameters = new ArrayList();
/*     */   }
/*     */   
/*     */   public CorpsHistory()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CorpsHistory(CorpsHistory _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CorpsHistory(xbean.CorpsHistory _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof CorpsHistory)) { assign((CorpsHistory)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CorpsHistory _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.recordtime = _o_.recordtime;
/*  59 */     this.historytype = _o_.historytype;
/*  60 */     this.parameters = new ArrayList();
/*  61 */     this.parameters.addAll(_o_.parameters);
/*  62 */     this.historyid = _o_.historyid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.recordtime = _o_.recordtime;
/*  68 */     this.historytype = _o_.historytype;
/*  69 */     this.parameters = new ArrayList();
/*  70 */     this.parameters.addAll(_o_.parameters);
/*  71 */     this.historyid = _o_.historyid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.marshal(this.recordtime);
/*  79 */     _os_.marshal(this.historytype);
/*  80 */     _os_.compact_uint32(this.parameters.size());
/*  81 */     for (String _v_ : this.parameters)
/*     */     {
/*  83 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  85 */     _os_.marshal(this.historyid);
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     this.recordtime = _os_.unmarshal_int();
/*  94 */     this.historytype = _os_.unmarshal_int();
/*  95 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  97 */       String _v_ = "";
/*  98 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  99 */       this.parameters.add(_v_);
/*     */     }
/* 101 */     this.historyid = _os_.unmarshal_int();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     _size_ += CodedOutputStream.computeInt32Size(1, this.recordtime);
/* 111 */     _size_ += CodedOutputStream.computeInt32Size(2, this.historytype);
/* 112 */     for (String _v_ : this.parameters)
/*     */     {
/*     */       try
/*     */       {
/* 116 */         _size_ += CodedOutputStream.computeBytesSize(3, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 120 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/*     */     }
/* 123 */     _size_ += CodedOutputStream.computeInt32Size(4, this.historyid);
/* 124 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 133 */       _output_.writeInt32(1, this.recordtime);
/* 134 */       _output_.writeInt32(2, this.historytype);
/* 135 */       for (String _v_ : this.parameters)
/*     */       {
/* 137 */         _output_.writeBytes(3, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */       }
/* 139 */       _output_.writeInt32(4, this.historyid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 143 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 145 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 151 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 154 */       boolean done = false;
/* 155 */       while (!done)
/*     */       {
/* 157 */         int tag = _input_.readTag();
/* 158 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 162 */           done = true;
/* 163 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 167 */           this.recordtime = _input_.readInt32();
/* 168 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 172 */           this.historytype = _input_.readInt32();
/* 173 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 177 */           String _v_ = "";
/* 178 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/* 179 */           this.parameters.add(_v_);
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 184 */           this.historyid = _input_.readInt32();
/* 185 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 189 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 191 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 200 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 204 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 206 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CorpsHistory copy()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new CorpsHistory(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CorpsHistory toData()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CorpsHistory toBean()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new CorpsHistory(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CorpsHistory toDataIf()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CorpsHistory toBeanIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRecordtime()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.recordtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getHistorytype()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.historytype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<String> getParameters()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return xdb.Logs.logList(new LogKey(this, "parameters"), this.parameters);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<String> getParametersAsData()
/*     */   {
/* 276 */     _xdb_verify_unsafe_();
/*     */     
/* 278 */     CorpsHistory _o_ = this;
/* 279 */     List<String> parameters = new ArrayList();
/* 280 */     parameters.addAll(_o_.parameters);
/* 281 */     return parameters;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getHistoryid()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     return this.historyid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRecordtime(int _v_)
/*     */   {
/* 296 */     _xdb_verify_unsafe_();
/* 297 */     xdb.Logs.logIf(new LogKey(this, "recordtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 301 */         new xdb.logs.LogInt(this, CorpsHistory.this.recordtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 305 */             CorpsHistory.this.recordtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 309 */     });
/* 310 */     this.recordtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHistorytype(int _v_)
/*     */   {
/* 317 */     _xdb_verify_unsafe_();
/* 318 */     xdb.Logs.logIf(new LogKey(this, "historytype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 322 */         new xdb.logs.LogInt(this, CorpsHistory.this.historytype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 326 */             CorpsHistory.this.historytype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 330 */     });
/* 331 */     this.historytype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHistoryid(int _v_)
/*     */   {
/* 338 */     _xdb_verify_unsafe_();
/* 339 */     xdb.Logs.logIf(new LogKey(this, "historyid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 343 */         new xdb.logs.LogInt(this, CorpsHistory.this.historyid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 347 */             CorpsHistory.this.historyid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 351 */     });
/* 352 */     this.historyid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 358 */     _xdb_verify_unsafe_();
/* 359 */     CorpsHistory _o_ = null;
/* 360 */     if ((_o1_ instanceof CorpsHistory)) { _o_ = (CorpsHistory)_o1_;
/* 361 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 362 */       return false;
/* 363 */     if (this.recordtime != _o_.recordtime) return false;
/* 364 */     if (this.historytype != _o_.historytype) return false;
/* 365 */     if (!this.parameters.equals(_o_.parameters)) return false;
/* 366 */     if (this.historyid != _o_.historyid) return false;
/* 367 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 373 */     _xdb_verify_unsafe_();
/* 374 */     int _h_ = 0;
/* 375 */     _h_ += this.recordtime;
/* 376 */     _h_ += this.historytype;
/* 377 */     _h_ += this.parameters.hashCode();
/* 378 */     _h_ += this.historyid;
/* 379 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 385 */     _xdb_verify_unsafe_();
/* 386 */     StringBuilder _sb_ = new StringBuilder();
/* 387 */     _sb_.append("(");
/* 388 */     _sb_.append(this.recordtime);
/* 389 */     _sb_.append(",");
/* 390 */     _sb_.append(this.historytype);
/* 391 */     _sb_.append(",");
/* 392 */     _sb_.append(this.parameters);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.historyid);
/* 395 */     _sb_.append(")");
/* 396 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 402 */     ListenableBean lb = new ListenableBean();
/* 403 */     lb.add(new ListenableChanged().setVarName("recordtime"));
/* 404 */     lb.add(new ListenableChanged().setVarName("historytype"));
/* 405 */     lb.add(new ListenableChanged().setVarName("parameters"));
/* 406 */     lb.add(new ListenableChanged().setVarName("historyid"));
/* 407 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CorpsHistory {
/*     */     private Const() {}
/*     */     
/*     */     CorpsHistory nThis() {
/* 414 */       return CorpsHistory.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 420 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsHistory copy()
/*     */     {
/* 426 */       return CorpsHistory.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsHistory toData()
/*     */     {
/* 432 */       return CorpsHistory.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CorpsHistory toBean()
/*     */     {
/* 437 */       return CorpsHistory.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsHistory toDataIf()
/*     */     {
/* 443 */       return CorpsHistory.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CorpsHistory toBeanIf()
/*     */     {
/* 448 */       return CorpsHistory.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRecordtime()
/*     */     {
/* 455 */       CorpsHistory.this._xdb_verify_unsafe_();
/* 456 */       return CorpsHistory.this.recordtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHistorytype()
/*     */     {
/* 463 */       CorpsHistory.this._xdb_verify_unsafe_();
/* 464 */       return CorpsHistory.this.historytype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getParameters()
/*     */     {
/* 471 */       CorpsHistory.this._xdb_verify_unsafe_();
/* 472 */       return xdb.Consts.constList(CorpsHistory.this.parameters);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<String> getParametersAsData()
/*     */     {
/* 478 */       CorpsHistory.this._xdb_verify_unsafe_();
/*     */       
/* 480 */       CorpsHistory _o_ = CorpsHistory.this;
/* 481 */       List<String> parameters = new ArrayList();
/* 482 */       parameters.addAll(_o_.parameters);
/* 483 */       return parameters;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHistoryid()
/*     */     {
/* 490 */       CorpsHistory.this._xdb_verify_unsafe_();
/* 491 */       return CorpsHistory.this.historyid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRecordtime(int _v_)
/*     */     {
/* 498 */       CorpsHistory.this._xdb_verify_unsafe_();
/* 499 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHistorytype(int _v_)
/*     */     {
/* 506 */       CorpsHistory.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHistoryid(int _v_)
/*     */     {
/* 514 */       CorpsHistory.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 521 */       CorpsHistory.this._xdb_verify_unsafe_();
/* 522 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 528 */       CorpsHistory.this._xdb_verify_unsafe_();
/* 529 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 535 */       return CorpsHistory.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 541 */       return CorpsHistory.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 547 */       CorpsHistory.this._xdb_verify_unsafe_();
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 554 */       return CorpsHistory.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 560 */       return CorpsHistory.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 566 */       CorpsHistory.this._xdb_verify_unsafe_();
/* 567 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 573 */       return CorpsHistory.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 579 */       return CorpsHistory.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 585 */       return CorpsHistory.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 591 */       return CorpsHistory.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 597 */       return CorpsHistory.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 603 */       return CorpsHistory.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 609 */       return CorpsHistory.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CorpsHistory
/*     */   {
/*     */     private int recordtime;
/*     */     
/*     */     private int historytype;
/*     */     
/*     */     private ArrayList<String> parameters;
/*     */     
/*     */     private int historyid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 627 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 632 */       this.parameters = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.CorpsHistory _o1_)
/*     */     {
/* 637 */       if ((_o1_ instanceof CorpsHistory)) { assign((CorpsHistory)_o1_);
/* 638 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 639 */       } else if ((_o1_ instanceof CorpsHistory.Const)) assign(((CorpsHistory.Const)_o1_).nThis()); else {
/* 640 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CorpsHistory _o_) {
/* 645 */       this.recordtime = _o_.recordtime;
/* 646 */       this.historytype = _o_.historytype;
/* 647 */       this.parameters = new ArrayList();
/* 648 */       this.parameters.addAll(_o_.parameters);
/* 649 */       this.historyid = _o_.historyid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 654 */       this.recordtime = _o_.recordtime;
/* 655 */       this.historytype = _o_.historytype;
/* 656 */       this.parameters = new ArrayList();
/* 657 */       this.parameters.addAll(_o_.parameters);
/* 658 */       this.historyid = _o_.historyid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 664 */       _os_.marshal(this.recordtime);
/* 665 */       _os_.marshal(this.historytype);
/* 666 */       _os_.compact_uint32(this.parameters.size());
/* 667 */       for (String _v_ : this.parameters)
/*     */       {
/* 669 */         _os_.marshal(_v_, "UTF-16LE");
/*     */       }
/* 671 */       _os_.marshal(this.historyid);
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 678 */       this.recordtime = _os_.unmarshal_int();
/* 679 */       this.historytype = _os_.unmarshal_int();
/* 680 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 682 */         String _v_ = "";
/* 683 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/* 684 */         this.parameters.add(_v_);
/*     */       }
/* 686 */       this.historyid = _os_.unmarshal_int();
/* 687 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 693 */       int _size_ = 0;
/* 694 */       _size_ += CodedOutputStream.computeInt32Size(1, this.recordtime);
/* 695 */       _size_ += CodedOutputStream.computeInt32Size(2, this.historytype);
/* 696 */       for (String _v_ : this.parameters)
/*     */       {
/*     */         try
/*     */         {
/* 700 */           _size_ += CodedOutputStream.computeBytesSize(3, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */         }
/*     */         catch (java.io.UnsupportedEncodingException e)
/*     */         {
/* 704 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*     */         }
/*     */       }
/* 707 */       _size_ += CodedOutputStream.computeInt32Size(4, this.historyid);
/* 708 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 716 */         _output_.writeInt32(1, this.recordtime);
/* 717 */         _output_.writeInt32(2, this.historytype);
/* 718 */         for (String _v_ : this.parameters)
/*     */         {
/* 720 */           _output_.writeBytes(3, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */         }
/* 722 */         _output_.writeInt32(4, this.historyid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 726 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 728 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 736 */         boolean done = false;
/* 737 */         while (!done)
/*     */         {
/* 739 */           int tag = _input_.readTag();
/* 740 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 744 */             done = true;
/* 745 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 749 */             this.recordtime = _input_.readInt32();
/* 750 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 754 */             this.historytype = _input_.readInt32();
/* 755 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 759 */             String _v_ = "";
/* 760 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 761 */             this.parameters.add(_v_);
/* 762 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 766 */             this.historyid = _input_.readInt32();
/* 767 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 771 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 773 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 782 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 786 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 788 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsHistory copy()
/*     */     {
/* 794 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsHistory toData()
/*     */     {
/* 800 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CorpsHistory toBean()
/*     */     {
/* 805 */       return new CorpsHistory(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsHistory toDataIf()
/*     */     {
/* 811 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CorpsHistory toBeanIf()
/*     */     {
/* 816 */       return new CorpsHistory(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 822 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 826 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 830 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 834 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 838 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 842 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 846 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRecordtime()
/*     */     {
/* 853 */       return this.recordtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHistorytype()
/*     */     {
/* 860 */       return this.historytype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getParameters()
/*     */     {
/* 867 */       return this.parameters;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getParametersAsData()
/*     */     {
/* 874 */       return this.parameters;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHistoryid()
/*     */     {
/* 881 */       return this.historyid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRecordtime(int _v_)
/*     */     {
/* 888 */       this.recordtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHistorytype(int _v_)
/*     */     {
/* 895 */       this.historytype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHistoryid(int _v_)
/*     */     {
/* 902 */       this.historyid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 908 */       if (!(_o1_ instanceof Data)) return false;
/* 909 */       Data _o_ = (Data)_o1_;
/* 910 */       if (this.recordtime != _o_.recordtime) return false;
/* 911 */       if (this.historytype != _o_.historytype) return false;
/* 912 */       if (!this.parameters.equals(_o_.parameters)) return false;
/* 913 */       if (this.historyid != _o_.historyid) return false;
/* 914 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 920 */       int _h_ = 0;
/* 921 */       _h_ += this.recordtime;
/* 922 */       _h_ += this.historytype;
/* 923 */       _h_ += this.parameters.hashCode();
/* 924 */       _h_ += this.historyid;
/* 925 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 931 */       StringBuilder _sb_ = new StringBuilder();
/* 932 */       _sb_.append("(");
/* 933 */       _sb_.append(this.recordtime);
/* 934 */       _sb_.append(",");
/* 935 */       _sb_.append(this.historytype);
/* 936 */       _sb_.append(",");
/* 937 */       _sb_.append(this.parameters);
/* 938 */       _sb_.append(",");
/* 939 */       _sb_.append(this.historyid);
/* 940 */       _sb_.append(")");
/* 941 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CorpsHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */