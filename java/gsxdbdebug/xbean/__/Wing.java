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
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class Wing extends XBean implements xbean.Wing
/*     */ {
/*     */   private ArrayList<xbean.WingInfo> winglist;
/*     */   private int curindex;
/*     */   private boolean isshowwing;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.winglist.clear();
/*  23 */     this.curindex = 0;
/*  24 */     this.isshowwing = false;
/*     */   }
/*     */   
/*     */   Wing(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.winglist = new ArrayList();
/*  31 */     this.curindex = 0;
/*  32 */     this.isshowwing = false;
/*     */   }
/*     */   
/*     */   public Wing()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Wing(Wing _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Wing(xbean.Wing _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof Wing)) { assign((Wing)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Wing _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.winglist = new ArrayList();
/*  58 */     for (xbean.WingInfo _v_ : _o_.winglist)
/*  59 */       this.winglist.add(new WingInfo(_v_, this, "winglist"));
/*  60 */     this.curindex = _o_.curindex;
/*  61 */     this.isshowwing = _o_.isshowwing;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.winglist = new ArrayList();
/*  67 */     for (xbean.WingInfo _v_ : _o_.winglist)
/*  68 */       this.winglist.add(new WingInfo(_v_, this, "winglist"));
/*  69 */     this.curindex = _o_.curindex;
/*  70 */     this.isshowwing = _o_.isshowwing;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     _os_.compact_uint32(this.winglist.size());
/*  78 */     for (xbean.WingInfo _v_ : this.winglist)
/*     */     {
/*  80 */       _v_.marshal(_os_);
/*     */     }
/*  82 */     _os_.marshal(this.curindex);
/*  83 */     _os_.marshal(this.isshowwing);
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  93 */       xbean.WingInfo _v_ = new WingInfo(0, this, "winglist");
/*  94 */       _v_.unmarshal(_os_);
/*  95 */       this.winglist.add(_v_);
/*     */     }
/*  97 */     this.curindex = _os_.unmarshal_int();
/*  98 */     this.isshowwing = _os_.unmarshal_boolean();
/*  99 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 105 */     _xdb_verify_unsafe_();
/* 106 */     int _size_ = 0;
/* 107 */     for (xbean.WingInfo _v_ : this.winglist)
/*     */     {
/* 109 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 111 */     _size_ += CodedOutputStream.computeInt32Size(2, this.curindex);
/* 112 */     _size_ += CodedOutputStream.computeBoolSize(3, this.isshowwing);
/* 113 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 119 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 122 */       for (xbean.WingInfo _v_ : this.winglist)
/*     */       {
/* 124 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 126 */       _output_.writeInt32(2, this.curindex);
/* 127 */       _output_.writeBool(3, this.isshowwing);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 131 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 133 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 139 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 142 */       boolean done = false;
/* 143 */       while (!done)
/*     */       {
/* 145 */         int tag = _input_.readTag();
/* 146 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 150 */           done = true;
/* 151 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 155 */           xbean.WingInfo _v_ = new WingInfo(0, this, "winglist");
/* 156 */           _input_.readMessage(_v_);
/* 157 */           this.winglist.add(_v_);
/* 158 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 162 */           this.curindex = _input_.readInt32();
/* 163 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 167 */           this.isshowwing = _input_.readBool();
/* 168 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 172 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 174 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 183 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 187 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 189 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Wing copy()
/*     */   {
/* 195 */     _xdb_verify_unsafe_();
/* 196 */     return new Wing(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Wing toData()
/*     */   {
/* 202 */     _xdb_verify_unsafe_();
/* 203 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Wing toBean()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return new Wing(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Wing toDataIf()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Wing toBeanIf()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.WingInfo> getWinglist()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return xdb.Logs.logList(new LogKey(this, "winglist"), this.winglist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.WingInfo> getWinglistAsData()
/*     */   {
/* 243 */     _xdb_verify_unsafe_();
/*     */     
/* 245 */     Wing _o_ = this;
/* 246 */     List<xbean.WingInfo> winglist = new ArrayList();
/* 247 */     for (xbean.WingInfo _v_ : _o_.winglist)
/* 248 */       winglist.add(new WingInfo.Data(_v_));
/* 249 */     return winglist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCurindex()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     return this.curindex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIsshowwing()
/*     */   {
/* 264 */     _xdb_verify_unsafe_();
/* 265 */     return this.isshowwing;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCurindex(int _v_)
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     xdb.Logs.logIf(new LogKey(this, "curindex")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 277 */         new xdb.logs.LogInt(this, Wing.this.curindex)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 281 */             Wing.this.curindex = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 285 */     });
/* 286 */     this.curindex = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsshowwing(boolean _v_)
/*     */   {
/* 293 */     _xdb_verify_unsafe_();
/* 294 */     xdb.Logs.logIf(new LogKey(this, "isshowwing")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 298 */         new xdb.logs.LogObject(this, Boolean.valueOf(Wing.this.isshowwing))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 302 */             Wing.this.isshowwing = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 306 */     });
/* 307 */     this.isshowwing = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     Wing _o_ = null;
/* 315 */     if ((_o1_ instanceof Wing)) { _o_ = (Wing)_o1_;
/* 316 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 317 */       return false;
/* 318 */     if (!this.winglist.equals(_o_.winglist)) return false;
/* 319 */     if (this.curindex != _o_.curindex) return false;
/* 320 */     if (this.isshowwing != _o_.isshowwing) return false;
/* 321 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 327 */     _xdb_verify_unsafe_();
/* 328 */     int _h_ = 0;
/* 329 */     _h_ += this.winglist.hashCode();
/* 330 */     _h_ += this.curindex;
/* 331 */     _h_ += (this.isshowwing ? 1231 : 1237);
/* 332 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 338 */     _xdb_verify_unsafe_();
/* 339 */     StringBuilder _sb_ = new StringBuilder();
/* 340 */     _sb_.append("(");
/* 341 */     _sb_.append(this.winglist);
/* 342 */     _sb_.append(",");
/* 343 */     _sb_.append(this.curindex);
/* 344 */     _sb_.append(",");
/* 345 */     _sb_.append(this.isshowwing);
/* 346 */     _sb_.append(")");
/* 347 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 353 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 354 */     lb.add(new ListenableChanged().setVarName("winglist"));
/* 355 */     lb.add(new ListenableChanged().setVarName("curindex"));
/* 356 */     lb.add(new ListenableChanged().setVarName("isshowwing"));
/* 357 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Wing {
/*     */     private Const() {}
/*     */     
/*     */     Wing nThis() {
/* 364 */       return Wing.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 370 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Wing copy()
/*     */     {
/* 376 */       return Wing.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Wing toData()
/*     */     {
/* 382 */       return Wing.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Wing toBean()
/*     */     {
/* 387 */       return Wing.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Wing toDataIf()
/*     */     {
/* 393 */       return Wing.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Wing toBeanIf()
/*     */     {
/* 398 */       return Wing.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.WingInfo> getWinglist()
/*     */     {
/* 405 */       Wing.this._xdb_verify_unsafe_();
/* 406 */       return xdb.Consts.constList(Wing.this.winglist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.WingInfo> getWinglistAsData()
/*     */     {
/* 412 */       Wing.this._xdb_verify_unsafe_();
/*     */       
/* 414 */       Wing _o_ = Wing.this;
/* 415 */       List<xbean.WingInfo> winglist = new ArrayList();
/* 416 */       for (xbean.WingInfo _v_ : _o_.winglist)
/* 417 */         winglist.add(new WingInfo.Data(_v_));
/* 418 */       return winglist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurindex()
/*     */     {
/* 425 */       Wing.this._xdb_verify_unsafe_();
/* 426 */       return Wing.this.curindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsshowwing()
/*     */     {
/* 433 */       Wing.this._xdb_verify_unsafe_();
/* 434 */       return Wing.this.isshowwing;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurindex(int _v_)
/*     */     {
/* 441 */       Wing.this._xdb_verify_unsafe_();
/* 442 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsshowwing(boolean _v_)
/*     */     {
/* 449 */       Wing.this._xdb_verify_unsafe_();
/* 450 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 456 */       Wing.this._xdb_verify_unsafe_();
/* 457 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 463 */       Wing.this._xdb_verify_unsafe_();
/* 464 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 470 */       return Wing.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 476 */       return Wing.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 482 */       Wing.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 489 */       return Wing.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 495 */       return Wing.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 501 */       Wing.this._xdb_verify_unsafe_();
/* 502 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 508 */       return Wing.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 514 */       return Wing.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 520 */       return Wing.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 526 */       return Wing.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 532 */       return Wing.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 538 */       return Wing.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 544 */       return Wing.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Wing
/*     */   {
/*     */     private ArrayList<xbean.WingInfo> winglist;
/*     */     
/*     */     private int curindex;
/*     */     
/*     */     private boolean isshowwing;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 560 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 565 */       this.winglist = new ArrayList();
/* 566 */       this.curindex = 0;
/* 567 */       this.isshowwing = false;
/*     */     }
/*     */     
/*     */     Data(xbean.Wing _o1_)
/*     */     {
/* 572 */       if ((_o1_ instanceof Wing)) { assign((Wing)_o1_);
/* 573 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 574 */       } else if ((_o1_ instanceof Wing.Const)) assign(((Wing.Const)_o1_).nThis()); else {
/* 575 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Wing _o_) {
/* 580 */       this.winglist = new ArrayList();
/* 581 */       for (xbean.WingInfo _v_ : _o_.winglist)
/* 582 */         this.winglist.add(new WingInfo.Data(_v_));
/* 583 */       this.curindex = _o_.curindex;
/* 584 */       this.isshowwing = _o_.isshowwing;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 589 */       this.winglist = new ArrayList();
/* 590 */       for (xbean.WingInfo _v_ : _o_.winglist)
/* 591 */         this.winglist.add(new WingInfo.Data(_v_));
/* 592 */       this.curindex = _o_.curindex;
/* 593 */       this.isshowwing = _o_.isshowwing;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 599 */       _os_.compact_uint32(this.winglist.size());
/* 600 */       for (xbean.WingInfo _v_ : this.winglist)
/*     */       {
/* 602 */         _v_.marshal(_os_);
/*     */       }
/* 604 */       _os_.marshal(this.curindex);
/* 605 */       _os_.marshal(this.isshowwing);
/* 606 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 612 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 614 */         xbean.WingInfo _v_ = xbean.Pod.newWingInfoData();
/* 615 */         _v_.unmarshal(_os_);
/* 616 */         this.winglist.add(_v_);
/*     */       }
/* 618 */       this.curindex = _os_.unmarshal_int();
/* 619 */       this.isshowwing = _os_.unmarshal_boolean();
/* 620 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 626 */       int _size_ = 0;
/* 627 */       for (xbean.WingInfo _v_ : this.winglist)
/*     */       {
/* 629 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 631 */       _size_ += CodedOutputStream.computeInt32Size(2, this.curindex);
/* 632 */       _size_ += CodedOutputStream.computeBoolSize(3, this.isshowwing);
/* 633 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 641 */         for (xbean.WingInfo _v_ : this.winglist)
/*     */         {
/* 643 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 645 */         _output_.writeInt32(2, this.curindex);
/* 646 */         _output_.writeBool(3, this.isshowwing);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 650 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 652 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 660 */         boolean done = false;
/* 661 */         while (!done)
/*     */         {
/* 663 */           int tag = _input_.readTag();
/* 664 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 668 */             done = true;
/* 669 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 673 */             xbean.WingInfo _v_ = xbean.Pod.newWingInfoData();
/* 674 */             _input_.readMessage(_v_);
/* 675 */             this.winglist.add(_v_);
/* 676 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 680 */             this.curindex = _input_.readInt32();
/* 681 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 685 */             this.isshowwing = _input_.readBool();
/* 686 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 690 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 692 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 701 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 705 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 707 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Wing copy()
/*     */     {
/* 713 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Wing toData()
/*     */     {
/* 719 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Wing toBean()
/*     */     {
/* 724 */       return new Wing(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Wing toDataIf()
/*     */     {
/* 730 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Wing toBeanIf()
/*     */     {
/* 735 */       return new Wing(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 741 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 745 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 749 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 753 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 757 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 761 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 765 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.WingInfo> getWinglist()
/*     */     {
/* 772 */       return this.winglist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.WingInfo> getWinglistAsData()
/*     */     {
/* 779 */       return this.winglist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurindex()
/*     */     {
/* 786 */       return this.curindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsshowwing()
/*     */     {
/* 793 */       return this.isshowwing;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurindex(int _v_)
/*     */     {
/* 800 */       this.curindex = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsshowwing(boolean _v_)
/*     */     {
/* 807 */       this.isshowwing = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 813 */       if (!(_o1_ instanceof Data)) return false;
/* 814 */       Data _o_ = (Data)_o1_;
/* 815 */       if (!this.winglist.equals(_o_.winglist)) return false;
/* 816 */       if (this.curindex != _o_.curindex) return false;
/* 817 */       if (this.isshowwing != _o_.isshowwing) return false;
/* 818 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 824 */       int _h_ = 0;
/* 825 */       _h_ += this.winglist.hashCode();
/* 826 */       _h_ += this.curindex;
/* 827 */       _h_ += (this.isshowwing ? 1231 : 1237);
/* 828 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 834 */       StringBuilder _sb_ = new StringBuilder();
/* 835 */       _sb_.append("(");
/* 836 */       _sb_.append(this.winglist);
/* 837 */       _sb_.append(",");
/* 838 */       _sb_.append(this.curindex);
/* 839 */       _sb_.append(",");
/* 840 */       _sb_.append(this.isshowwing);
/* 841 */       _sb_.append(")");
/* 842 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Wing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */