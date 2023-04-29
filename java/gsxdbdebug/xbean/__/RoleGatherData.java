/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class RoleGatherData extends XBean implements xbean.RoleGatherData
/*     */ {
/*     */   private int totalsource;
/*     */   private int totalcount;
/*     */   private int point;
/*     */   private long gatherinstanceid;
/*     */   private long gathersessionid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.totalsource = 0;
/*  27 */     this.totalcount = 0;
/*  28 */     this.point = 0;
/*  29 */     this.gatherinstanceid = 0L;
/*  30 */     this.gathersessionid = 0L;
/*     */   }
/*     */   
/*     */   RoleGatherData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public RoleGatherData()
/*     */   {
/*  40 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleGatherData(RoleGatherData _o_)
/*     */   {
/*  45 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleGatherData(xbean.RoleGatherData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  50 */     super(_xp_, _vn_);
/*  51 */     if ((_o1_ instanceof RoleGatherData)) { assign((RoleGatherData)_o1_);
/*  52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  54 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleGatherData _o_) {
/*  59 */     _o_._xdb_verify_unsafe_();
/*  60 */     this.totalsource = _o_.totalsource;
/*  61 */     this.totalcount = _o_.totalcount;
/*  62 */     this.point = _o_.point;
/*  63 */     this.gatherinstanceid = _o_.gatherinstanceid;
/*  64 */     this.gathersessionid = _o_.gathersessionid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.totalsource = _o_.totalsource;
/*  70 */     this.totalcount = _o_.totalcount;
/*  71 */     this.point = _o_.point;
/*  72 */     this.gatherinstanceid = _o_.gatherinstanceid;
/*  73 */     this.gathersessionid = _o_.gathersessionid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.totalsource);
/*  81 */     _os_.marshal(this.totalcount);
/*  82 */     _os_.marshal(this.point);
/*  83 */     _os_.marshal(this.gatherinstanceid);
/*  84 */     _os_.marshal(this.gathersessionid);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     this.totalsource = _os_.unmarshal_int();
/*  93 */     this.totalcount = _os_.unmarshal_int();
/*  94 */     this.point = _os_.unmarshal_int();
/*  95 */     this.gatherinstanceid = _os_.unmarshal_long();
/*  96 */     this.gathersessionid = _os_.unmarshal_long();
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     _size_ += CodedOutputStream.computeInt32Size(1, this.totalsource);
/* 106 */     _size_ += CodedOutputStream.computeInt32Size(2, this.totalcount);
/* 107 */     _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(4, this.gatherinstanceid);
/* 109 */     _size_ += CodedOutputStream.computeInt64Size(5, this.gathersessionid);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt32(1, this.totalsource);
/* 120 */       _output_.writeInt32(2, this.totalcount);
/* 121 */       _output_.writeInt32(3, this.point);
/* 122 */       _output_.writeInt64(4, this.gatherinstanceid);
/* 123 */       _output_.writeInt64(5, this.gathersessionid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 127 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 129 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       boolean done = false;
/* 139 */       while (!done)
/*     */       {
/* 141 */         int tag = _input_.readTag();
/* 142 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 146 */           done = true;
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 151 */           this.totalsource = _input_.readInt32();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           this.totalcount = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 161 */           this.point = _input_.readInt32();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 166 */           this.gatherinstanceid = _input_.readInt64();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 171 */           this.gathersessionid = _input_.readInt64();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGatherData copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new RoleGatherData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGatherData toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleGatherData toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new RoleGatherData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleGatherData toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleGatherData toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTotalsource()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.totalsource;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTotalcount()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return this.totalcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPoint()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     return this.point;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getGatherinstanceid()
/*     */   {
/* 264 */     _xdb_verify_unsafe_();
/* 265 */     return this.gatherinstanceid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getGathersessionid()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return this.gathersessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalsource(int _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "totalsource")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 285 */         new LogInt(this, RoleGatherData.this.totalsource)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             RoleGatherData.this.totalsource = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.totalsource = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalcount(int _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "totalcount")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 306 */         new LogInt(this, RoleGatherData.this.totalcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             RoleGatherData.this.totalcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.totalcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPoint(int _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new LogKey(this, "point")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 327 */         new LogInt(this, RoleGatherData.this.point)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             RoleGatherData.this.point = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.point = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGatherinstanceid(long _v_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     xdb.Logs.logIf(new LogKey(this, "gatherinstanceid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 348 */         new xdb.logs.LogLong(this, RoleGatherData.this.gatherinstanceid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 352 */             RoleGatherData.this.gatherinstanceid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 356 */     });
/* 357 */     this.gatherinstanceid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGathersessionid(long _v_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     xdb.Logs.logIf(new LogKey(this, "gathersessionid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 369 */         new xdb.logs.LogLong(this, RoleGatherData.this.gathersessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 373 */             RoleGatherData.this.gathersessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 377 */     });
/* 378 */     this.gathersessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 384 */     _xdb_verify_unsafe_();
/* 385 */     RoleGatherData _o_ = null;
/* 386 */     if ((_o1_ instanceof RoleGatherData)) { _o_ = (RoleGatherData)_o1_;
/* 387 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 388 */       return false;
/* 389 */     if (this.totalsource != _o_.totalsource) return false;
/* 390 */     if (this.totalcount != _o_.totalcount) return false;
/* 391 */     if (this.point != _o_.point) return false;
/* 392 */     if (this.gatherinstanceid != _o_.gatherinstanceid) return false;
/* 393 */     if (this.gathersessionid != _o_.gathersessionid) return false;
/* 394 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 400 */     _xdb_verify_unsafe_();
/* 401 */     int _h_ = 0;
/* 402 */     _h_ += this.totalsource;
/* 403 */     _h_ += this.totalcount;
/* 404 */     _h_ += this.point;
/* 405 */     _h_ = (int)(_h_ + this.gatherinstanceid);
/* 406 */     _h_ = (int)(_h_ + this.gathersessionid);
/* 407 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 413 */     _xdb_verify_unsafe_();
/* 414 */     StringBuilder _sb_ = new StringBuilder();
/* 415 */     _sb_.append("(");
/* 416 */     _sb_.append(this.totalsource);
/* 417 */     _sb_.append(",");
/* 418 */     _sb_.append(this.totalcount);
/* 419 */     _sb_.append(",");
/* 420 */     _sb_.append(this.point);
/* 421 */     _sb_.append(",");
/* 422 */     _sb_.append(this.gatherinstanceid);
/* 423 */     _sb_.append(",");
/* 424 */     _sb_.append(this.gathersessionid);
/* 425 */     _sb_.append(")");
/* 426 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 432 */     ListenableBean lb = new ListenableBean();
/* 433 */     lb.add(new ListenableChanged().setVarName("totalsource"));
/* 434 */     lb.add(new ListenableChanged().setVarName("totalcount"));
/* 435 */     lb.add(new ListenableChanged().setVarName("point"));
/* 436 */     lb.add(new ListenableChanged().setVarName("gatherinstanceid"));
/* 437 */     lb.add(new ListenableChanged().setVarName("gathersessionid"));
/* 438 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleGatherData {
/*     */     private Const() {}
/*     */     
/*     */     RoleGatherData nThis() {
/* 445 */       return RoleGatherData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGatherData copy()
/*     */     {
/* 457 */       return RoleGatherData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGatherData toData()
/*     */     {
/* 463 */       return RoleGatherData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleGatherData toBean()
/*     */     {
/* 468 */       return RoleGatherData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGatherData toDataIf()
/*     */     {
/* 474 */       return RoleGatherData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleGatherData toBeanIf()
/*     */     {
/* 479 */       return RoleGatherData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalsource()
/*     */     {
/* 486 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 487 */       return RoleGatherData.this.totalsource;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalcount()
/*     */     {
/* 494 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 495 */       return RoleGatherData.this.totalcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPoint()
/*     */     {
/* 502 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 503 */       return RoleGatherData.this.point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGatherinstanceid()
/*     */     {
/* 510 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 511 */       return RoleGatherData.this.gatherinstanceid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGathersessionid()
/*     */     {
/* 518 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 519 */       return RoleGatherData.this.gathersessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalsource(int _v_)
/*     */     {
/* 526 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 527 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalcount(int _v_)
/*     */     {
/* 534 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPoint(int _v_)
/*     */     {
/* 542 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 543 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGatherinstanceid(long _v_)
/*     */     {
/* 550 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGathersessionid(long _v_)
/*     */     {
/* 558 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 565 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 566 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 572 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 573 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 579 */       return RoleGatherData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 585 */       return RoleGatherData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 591 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 598 */       return RoleGatherData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 604 */       return RoleGatherData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 610 */       RoleGatherData.this._xdb_verify_unsafe_();
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 617 */       return RoleGatherData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       return RoleGatherData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 629 */       return RoleGatherData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 635 */       return RoleGatherData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 641 */       return RoleGatherData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 647 */       return RoleGatherData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 653 */       return RoleGatherData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleGatherData
/*     */   {
/*     */     private int totalsource;
/*     */     
/*     */     private int totalcount;
/*     */     
/*     */     private int point;
/*     */     
/*     */     private long gatherinstanceid;
/*     */     
/*     */     private long gathersessionid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 673 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.RoleGatherData _o1_)
/*     */     {
/* 682 */       if ((_o1_ instanceof RoleGatherData)) { assign((RoleGatherData)_o1_);
/* 683 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 684 */       } else if ((_o1_ instanceof RoleGatherData.Const)) assign(((RoleGatherData.Const)_o1_).nThis()); else {
/* 685 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleGatherData _o_) {
/* 690 */       this.totalsource = _o_.totalsource;
/* 691 */       this.totalcount = _o_.totalcount;
/* 692 */       this.point = _o_.point;
/* 693 */       this.gatherinstanceid = _o_.gatherinstanceid;
/* 694 */       this.gathersessionid = _o_.gathersessionid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 699 */       this.totalsource = _o_.totalsource;
/* 700 */       this.totalcount = _o_.totalcount;
/* 701 */       this.point = _o_.point;
/* 702 */       this.gatherinstanceid = _o_.gatherinstanceid;
/* 703 */       this.gathersessionid = _o_.gathersessionid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 709 */       _os_.marshal(this.totalsource);
/* 710 */       _os_.marshal(this.totalcount);
/* 711 */       _os_.marshal(this.point);
/* 712 */       _os_.marshal(this.gatherinstanceid);
/* 713 */       _os_.marshal(this.gathersessionid);
/* 714 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 720 */       this.totalsource = _os_.unmarshal_int();
/* 721 */       this.totalcount = _os_.unmarshal_int();
/* 722 */       this.point = _os_.unmarshal_int();
/* 723 */       this.gatherinstanceid = _os_.unmarshal_long();
/* 724 */       this.gathersessionid = _os_.unmarshal_long();
/* 725 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 731 */       int _size_ = 0;
/* 732 */       _size_ += CodedOutputStream.computeInt32Size(1, this.totalsource);
/* 733 */       _size_ += CodedOutputStream.computeInt32Size(2, this.totalcount);
/* 734 */       _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/* 735 */       _size_ += CodedOutputStream.computeInt64Size(4, this.gatherinstanceid);
/* 736 */       _size_ += CodedOutputStream.computeInt64Size(5, this.gathersessionid);
/* 737 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 745 */         _output_.writeInt32(1, this.totalsource);
/* 746 */         _output_.writeInt32(2, this.totalcount);
/* 747 */         _output_.writeInt32(3, this.point);
/* 748 */         _output_.writeInt64(4, this.gatherinstanceid);
/* 749 */         _output_.writeInt64(5, this.gathersessionid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 753 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 755 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 763 */         boolean done = false;
/* 764 */         while (!done)
/*     */         {
/* 766 */           int tag = _input_.readTag();
/* 767 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 771 */             done = true;
/* 772 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 776 */             this.totalsource = _input_.readInt32();
/* 777 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 781 */             this.totalcount = _input_.readInt32();
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 786 */             this.point = _input_.readInt32();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 791 */             this.gatherinstanceid = _input_.readInt64();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 796 */             this.gathersessionid = _input_.readInt64();
/* 797 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 801 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 803 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 812 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 816 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 818 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGatherData copy()
/*     */     {
/* 824 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGatherData toData()
/*     */     {
/* 830 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleGatherData toBean()
/*     */     {
/* 835 */       return new RoleGatherData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleGatherData toDataIf()
/*     */     {
/* 841 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleGatherData toBeanIf()
/*     */     {
/* 846 */       return new RoleGatherData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 852 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 872 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 876 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalsource()
/*     */     {
/* 883 */       return this.totalsource;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotalcount()
/*     */     {
/* 890 */       return this.totalcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPoint()
/*     */     {
/* 897 */       return this.point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGatherinstanceid()
/*     */     {
/* 904 */       return this.gatherinstanceid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGathersessionid()
/*     */     {
/* 911 */       return this.gathersessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalsource(int _v_)
/*     */     {
/* 918 */       this.totalsource = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalcount(int _v_)
/*     */     {
/* 925 */       this.totalcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPoint(int _v_)
/*     */     {
/* 932 */       this.point = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGatherinstanceid(long _v_)
/*     */     {
/* 939 */       this.gatherinstanceid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGathersessionid(long _v_)
/*     */     {
/* 946 */       this.gathersessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 952 */       if (!(_o1_ instanceof Data)) return false;
/* 953 */       Data _o_ = (Data)_o1_;
/* 954 */       if (this.totalsource != _o_.totalsource) return false;
/* 955 */       if (this.totalcount != _o_.totalcount) return false;
/* 956 */       if (this.point != _o_.point) return false;
/* 957 */       if (this.gatherinstanceid != _o_.gatherinstanceid) return false;
/* 958 */       if (this.gathersessionid != _o_.gathersessionid) return false;
/* 959 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 965 */       int _h_ = 0;
/* 966 */       _h_ += this.totalsource;
/* 967 */       _h_ += this.totalcount;
/* 968 */       _h_ += this.point;
/* 969 */       _h_ = (int)(_h_ + this.gatherinstanceid);
/* 970 */       _h_ = (int)(_h_ + this.gathersessionid);
/* 971 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 977 */       StringBuilder _sb_ = new StringBuilder();
/* 978 */       _sb_.append("(");
/* 979 */       _sb_.append(this.totalsource);
/* 980 */       _sb_.append(",");
/* 981 */       _sb_.append(this.totalcount);
/* 982 */       _sb_.append(",");
/* 983 */       _sb_.append(this.point);
/* 984 */       _sb_.append(",");
/* 985 */       _sb_.append(this.gatherinstanceid);
/* 986 */       _sb_.append(",");
/* 987 */       _sb_.append(this.gathersessionid);
/* 988 */       _sb_.append(")");
/* 989 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleGatherData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */