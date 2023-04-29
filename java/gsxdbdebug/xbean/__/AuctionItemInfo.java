/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class AuctionItemInfo extends XBean implements xbean.AuctionItemInfo
/*      */ {
/*      */   private long auctionroleid;
/*      */   private long endtime;
/*      */   private int auctioncount;
/*      */   private int auctionprice;
/*      */   private int itemid;
/*      */   private SetX<Long> auctionroleset;
/*      */   private int itemnum;
/*      */   private boolean issendtip;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.auctionroleid = 0L;
/*   33 */     this.endtime = 0L;
/*   34 */     this.auctioncount = 0;
/*   35 */     this.auctionprice = 0;
/*   36 */     this.itemid = 0;
/*   37 */     this.auctionroleset.clear();
/*   38 */     this.itemnum = 0;
/*   39 */     this.issendtip = false;
/*      */   }
/*      */   
/*      */   AuctionItemInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.auctionroleset = new SetX();
/*   46 */     this.issendtip = false;
/*      */   }
/*      */   
/*      */   public AuctionItemInfo()
/*      */   {
/*   51 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AuctionItemInfo(AuctionItemInfo _o_)
/*      */   {
/*   56 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AuctionItemInfo(xbean.AuctionItemInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   61 */     super(_xp_, _vn_);
/*   62 */     if ((_o1_ instanceof AuctionItemInfo)) { assign((AuctionItemInfo)_o1_);
/*   63 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   64 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   65 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AuctionItemInfo _o_) {
/*   70 */     _o_._xdb_verify_unsafe_();
/*   71 */     this.auctionroleid = _o_.auctionroleid;
/*   72 */     this.endtime = _o_.endtime;
/*   73 */     this.auctioncount = _o_.auctioncount;
/*   74 */     this.auctionprice = _o_.auctionprice;
/*   75 */     this.itemid = _o_.itemid;
/*   76 */     this.auctionroleset = new SetX();
/*   77 */     this.auctionroleset.addAll(_o_.auctionroleset);
/*   78 */     this.itemnum = _o_.itemnum;
/*   79 */     this.issendtip = _o_.issendtip;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   84 */     this.auctionroleid = _o_.auctionroleid;
/*   85 */     this.endtime = _o_.endtime;
/*   86 */     this.auctioncount = _o_.auctioncount;
/*   87 */     this.auctionprice = _o_.auctionprice;
/*   88 */     this.itemid = _o_.itemid;
/*   89 */     this.auctionroleset = new SetX();
/*   90 */     this.auctionroleset.addAll(_o_.auctionroleset);
/*   91 */     this.itemnum = _o_.itemnum;
/*   92 */     this.issendtip = _o_.issendtip;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   98 */     _xdb_verify_unsafe_();
/*   99 */     _os_.marshal(this.auctionroleid);
/*  100 */     _os_.marshal(this.endtime);
/*  101 */     _os_.marshal(this.auctioncount);
/*  102 */     _os_.marshal(this.auctionprice);
/*  103 */     _os_.marshal(this.itemid);
/*  104 */     _os_.compact_uint32(this.auctionroleset.size());
/*  105 */     for (Long _v_ : this.auctionroleset)
/*      */     {
/*  107 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  109 */     _os_.marshal(this.itemnum);
/*  110 */     _os_.marshal(this.issendtip);
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*  118 */     this.auctionroleid = _os_.unmarshal_long();
/*  119 */     this.endtime = _os_.unmarshal_long();
/*  120 */     this.auctioncount = _os_.unmarshal_int();
/*  121 */     this.auctionprice = _os_.unmarshal_int();
/*  122 */     this.itemid = _os_.unmarshal_int();
/*  123 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  125 */       long _v_ = 0L;
/*  126 */       _v_ = _os_.unmarshal_long();
/*  127 */       this.auctionroleset.add(Long.valueOf(_v_));
/*      */     }
/*  129 */     this.itemnum = _os_.unmarshal_int();
/*  130 */     this.issendtip = _os_.unmarshal_boolean();
/*  131 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  137 */     _xdb_verify_unsafe_();
/*  138 */     int _size_ = 0;
/*  139 */     _size_ += CodedOutputStream.computeInt64Size(1, this.auctionroleid);
/*  140 */     _size_ += CodedOutputStream.computeInt64Size(2, this.endtime);
/*  141 */     _size_ += CodedOutputStream.computeInt32Size(3, this.auctioncount);
/*  142 */     _size_ += CodedOutputStream.computeInt32Size(4, this.auctionprice);
/*  143 */     _size_ += CodedOutputStream.computeInt32Size(5, this.itemid);
/*  144 */     for (Long _v_ : this.auctionroleset)
/*      */     {
/*  146 */       _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */     }
/*  148 */     _size_ += CodedOutputStream.computeInt32Size(7, this.itemnum);
/*  149 */     _size_ += CodedOutputStream.computeBoolSize(8, this.issendtip);
/*  150 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  156 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  159 */       _output_.writeInt64(1, this.auctionroleid);
/*  160 */       _output_.writeInt64(2, this.endtime);
/*  161 */       _output_.writeInt32(3, this.auctioncount);
/*  162 */       _output_.writeInt32(4, this.auctionprice);
/*  163 */       _output_.writeInt32(5, this.itemid);
/*  164 */       for (Long _v_ : this.auctionroleset)
/*      */       {
/*  166 */         _output_.writeInt64(6, _v_.longValue());
/*      */       }
/*  168 */       _output_.writeInt32(7, this.itemnum);
/*  169 */       _output_.writeBool(8, this.issendtip);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  173 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  175 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  181 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  184 */       boolean done = false;
/*  185 */       while (!done)
/*      */       {
/*  187 */         int tag = _input_.readTag();
/*  188 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  192 */           done = true;
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  197 */           this.auctionroleid = _input_.readInt64();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  202 */           this.endtime = _input_.readInt64();
/*  203 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  207 */           this.auctioncount = _input_.readInt32();
/*  208 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  212 */           this.auctionprice = _input_.readInt32();
/*  213 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  217 */           this.itemid = _input_.readInt32();
/*  218 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  222 */           long _v_ = 0L;
/*  223 */           _v_ = _input_.readInt64();
/*  224 */           this.auctionroleset.add(Long.valueOf(_v_));
/*  225 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  229 */           this.itemnum = _input_.readInt32();
/*  230 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  234 */           this.issendtip = _input_.readBool();
/*  235 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  239 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  241 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  250 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  254 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  256 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AuctionItemInfo copy()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return new AuctionItemInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AuctionItemInfo toData()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AuctionItemInfo toBean()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return new AuctionItemInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AuctionItemInfo toDataIf()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AuctionItemInfo toBeanIf()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAuctionroleid()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return this.auctionroleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEndtime()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return this.endtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAuctioncount()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return this.auctioncount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAuctionprice()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return this.auctionprice;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItemid()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return this.itemid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getAuctionroleset()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return Logs.logSet(new LogKey(this, "auctionroleset"), this.auctionroleset);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getAuctionrolesetAsData()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*      */     
/*  352 */     AuctionItemInfo _o_ = this;
/*  353 */     Set<Long> auctionroleset = new SetX();
/*  354 */     auctionroleset.addAll(_o_.auctionroleset);
/*  355 */     return auctionroleset;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItemnum()
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*  363 */     return this.itemnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIssendtip()
/*      */   {
/*  370 */     _xdb_verify_unsafe_();
/*  371 */     return this.issendtip;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAuctionroleid(long _v_)
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     Logs.logIf(new LogKey(this, "auctionroleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  383 */         new xdb.logs.LogLong(this, AuctionItemInfo.this.auctionroleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  387 */             AuctionItemInfo.this.auctionroleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  391 */     });
/*  392 */     this.auctionroleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEndtime(long _v_)
/*      */   {
/*  399 */     _xdb_verify_unsafe_();
/*  400 */     Logs.logIf(new LogKey(this, "endtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  404 */         new xdb.logs.LogLong(this, AuctionItemInfo.this.endtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  408 */             AuctionItemInfo.this.endtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  412 */     });
/*  413 */     this.endtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAuctioncount(int _v_)
/*      */   {
/*  420 */     _xdb_verify_unsafe_();
/*  421 */     Logs.logIf(new LogKey(this, "auctioncount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  425 */         new LogInt(this, AuctionItemInfo.this.auctioncount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  429 */             AuctionItemInfo.this.auctioncount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  433 */     });
/*  434 */     this.auctioncount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAuctionprice(int _v_)
/*      */   {
/*  441 */     _xdb_verify_unsafe_();
/*  442 */     Logs.logIf(new LogKey(this, "auctionprice")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  446 */         new LogInt(this, AuctionItemInfo.this.auctionprice)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  450 */             AuctionItemInfo.this.auctionprice = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  454 */     });
/*  455 */     this.auctionprice = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItemid(int _v_)
/*      */   {
/*  462 */     _xdb_verify_unsafe_();
/*  463 */     Logs.logIf(new LogKey(this, "itemid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  467 */         new LogInt(this, AuctionItemInfo.this.itemid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  471 */             AuctionItemInfo.this.itemid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  475 */     });
/*  476 */     this.itemid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItemnum(int _v_)
/*      */   {
/*  483 */     _xdb_verify_unsafe_();
/*  484 */     Logs.logIf(new LogKey(this, "itemnum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  488 */         new LogInt(this, AuctionItemInfo.this.itemnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  492 */             AuctionItemInfo.this.itemnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  496 */     });
/*  497 */     this.itemnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIssendtip(boolean _v_)
/*      */   {
/*  504 */     _xdb_verify_unsafe_();
/*  505 */     Logs.logIf(new LogKey(this, "issendtip")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  509 */         new xdb.logs.LogObject(this, Boolean.valueOf(AuctionItemInfo.this.issendtip))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  513 */             AuctionItemInfo.this.issendtip = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  517 */     });
/*  518 */     this.issendtip = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  524 */     _xdb_verify_unsafe_();
/*  525 */     AuctionItemInfo _o_ = null;
/*  526 */     if ((_o1_ instanceof AuctionItemInfo)) { _o_ = (AuctionItemInfo)_o1_;
/*  527 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  528 */       return false;
/*  529 */     if (this.auctionroleid != _o_.auctionroleid) return false;
/*  530 */     if (this.endtime != _o_.endtime) return false;
/*  531 */     if (this.auctioncount != _o_.auctioncount) return false;
/*  532 */     if (this.auctionprice != _o_.auctionprice) return false;
/*  533 */     if (this.itemid != _o_.itemid) return false;
/*  534 */     if (!this.auctionroleset.equals(_o_.auctionroleset)) return false;
/*  535 */     if (this.itemnum != _o_.itemnum) return false;
/*  536 */     if (this.issendtip != _o_.issendtip) return false;
/*  537 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  543 */     _xdb_verify_unsafe_();
/*  544 */     int _h_ = 0;
/*  545 */     _h_ = (int)(_h_ + this.auctionroleid);
/*  546 */     _h_ = (int)(_h_ + this.endtime);
/*  547 */     _h_ += this.auctioncount;
/*  548 */     _h_ += this.auctionprice;
/*  549 */     _h_ += this.itemid;
/*  550 */     _h_ += this.auctionroleset.hashCode();
/*  551 */     _h_ += this.itemnum;
/*  552 */     _h_ += (this.issendtip ? 1231 : 1237);
/*  553 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  559 */     _xdb_verify_unsafe_();
/*  560 */     StringBuilder _sb_ = new StringBuilder();
/*  561 */     _sb_.append("(");
/*  562 */     _sb_.append(this.auctionroleid);
/*  563 */     _sb_.append(",");
/*  564 */     _sb_.append(this.endtime);
/*  565 */     _sb_.append(",");
/*  566 */     _sb_.append(this.auctioncount);
/*  567 */     _sb_.append(",");
/*  568 */     _sb_.append(this.auctionprice);
/*  569 */     _sb_.append(",");
/*  570 */     _sb_.append(this.itemid);
/*  571 */     _sb_.append(",");
/*  572 */     _sb_.append(this.auctionroleset);
/*  573 */     _sb_.append(",");
/*  574 */     _sb_.append(this.itemnum);
/*  575 */     _sb_.append(",");
/*  576 */     _sb_.append(this.issendtip);
/*  577 */     _sb_.append(")");
/*  578 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  584 */     ListenableBean lb = new ListenableBean();
/*  585 */     lb.add(new ListenableChanged().setVarName("auctionroleid"));
/*  586 */     lb.add(new ListenableChanged().setVarName("endtime"));
/*  587 */     lb.add(new ListenableChanged().setVarName("auctioncount"));
/*  588 */     lb.add(new ListenableChanged().setVarName("auctionprice"));
/*  589 */     lb.add(new ListenableChanged().setVarName("itemid"));
/*  590 */     lb.add(new xdb.logs.ListenableSet().setVarName("auctionroleset"));
/*  591 */     lb.add(new ListenableChanged().setVarName("itemnum"));
/*  592 */     lb.add(new ListenableChanged().setVarName("issendtip"));
/*  593 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AuctionItemInfo {
/*      */     private Const() {}
/*      */     
/*      */     AuctionItemInfo nThis() {
/*  600 */       return AuctionItemInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  606 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionItemInfo copy()
/*      */     {
/*  612 */       return AuctionItemInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionItemInfo toData()
/*      */     {
/*  618 */       return AuctionItemInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AuctionItemInfo toBean()
/*      */     {
/*  623 */       return AuctionItemInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionItemInfo toDataIf()
/*      */     {
/*  629 */       return AuctionItemInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AuctionItemInfo toBeanIf()
/*      */     {
/*  634 */       return AuctionItemInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAuctionroleid()
/*      */     {
/*  641 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  642 */       return AuctionItemInfo.this.auctionroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/*  649 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  650 */       return AuctionItemInfo.this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAuctioncount()
/*      */     {
/*  657 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  658 */       return AuctionItemInfo.this.auctioncount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAuctionprice()
/*      */     {
/*  665 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  666 */       return AuctionItemInfo.this.auctionprice;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemid()
/*      */     {
/*  673 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  674 */       return AuctionItemInfo.this.itemid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAuctionroleset()
/*      */     {
/*  681 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  682 */       return xdb.Consts.constSet(AuctionItemInfo.this.auctionroleset);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getAuctionrolesetAsData()
/*      */     {
/*  688 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*      */       
/*  690 */       AuctionItemInfo _o_ = AuctionItemInfo.this;
/*  691 */       Set<Long> auctionroleset = new SetX();
/*  692 */       auctionroleset.addAll(_o_.auctionroleset);
/*  693 */       return auctionroleset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemnum()
/*      */     {
/*  700 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  701 */       return AuctionItemInfo.this.itemnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIssendtip()
/*      */     {
/*  708 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  709 */       return AuctionItemInfo.this.issendtip;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctionroleid(long _v_)
/*      */     {
/*  716 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  717 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/*  724 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  725 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctioncount(int _v_)
/*      */     {
/*  732 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  733 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctionprice(int _v_)
/*      */     {
/*  740 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  741 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemid(int _v_)
/*      */     {
/*  748 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  749 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemnum(int _v_)
/*      */     {
/*  756 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  757 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIssendtip(boolean _v_)
/*      */     {
/*  764 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  765 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  771 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  772 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  778 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  779 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  785 */       return AuctionItemInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  791 */       return AuctionItemInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  797 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  798 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  804 */       return AuctionItemInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  810 */       return AuctionItemInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  816 */       AuctionItemInfo.this._xdb_verify_unsafe_();
/*  817 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  823 */       return AuctionItemInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  829 */       return AuctionItemInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  835 */       return AuctionItemInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  841 */       return AuctionItemInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  847 */       return AuctionItemInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  853 */       return AuctionItemInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  859 */       return AuctionItemInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AuctionItemInfo
/*      */   {
/*      */     private long auctionroleid;
/*      */     
/*      */     private long endtime;
/*      */     
/*      */     private int auctioncount;
/*      */     
/*      */     private int auctionprice;
/*      */     
/*      */     private int itemid;
/*      */     
/*      */     private HashSet<Long> auctionroleset;
/*      */     
/*      */     private int itemnum;
/*      */     
/*      */     private boolean issendtip;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  885 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  890 */       this.auctionroleset = new HashSet();
/*  891 */       this.issendtip = false;
/*      */     }
/*      */     
/*      */     Data(xbean.AuctionItemInfo _o1_)
/*      */     {
/*  896 */       if ((_o1_ instanceof AuctionItemInfo)) { assign((AuctionItemInfo)_o1_);
/*  897 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  898 */       } else if ((_o1_ instanceof AuctionItemInfo.Const)) assign(((AuctionItemInfo.Const)_o1_).nThis()); else {
/*  899 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AuctionItemInfo _o_) {
/*  904 */       this.auctionroleid = _o_.auctionroleid;
/*  905 */       this.endtime = _o_.endtime;
/*  906 */       this.auctioncount = _o_.auctioncount;
/*  907 */       this.auctionprice = _o_.auctionprice;
/*  908 */       this.itemid = _o_.itemid;
/*  909 */       this.auctionroleset = new HashSet();
/*  910 */       this.auctionroleset.addAll(_o_.auctionroleset);
/*  911 */       this.itemnum = _o_.itemnum;
/*  912 */       this.issendtip = _o_.issendtip;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  917 */       this.auctionroleid = _o_.auctionroleid;
/*  918 */       this.endtime = _o_.endtime;
/*  919 */       this.auctioncount = _o_.auctioncount;
/*  920 */       this.auctionprice = _o_.auctionprice;
/*  921 */       this.itemid = _o_.itemid;
/*  922 */       this.auctionroleset = new HashSet();
/*  923 */       this.auctionroleset.addAll(_o_.auctionroleset);
/*  924 */       this.itemnum = _o_.itemnum;
/*  925 */       this.issendtip = _o_.issendtip;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  931 */       _os_.marshal(this.auctionroleid);
/*  932 */       _os_.marshal(this.endtime);
/*  933 */       _os_.marshal(this.auctioncount);
/*  934 */       _os_.marshal(this.auctionprice);
/*  935 */       _os_.marshal(this.itemid);
/*  936 */       _os_.compact_uint32(this.auctionroleset.size());
/*  937 */       for (Long _v_ : this.auctionroleset)
/*      */       {
/*  939 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  941 */       _os_.marshal(this.itemnum);
/*  942 */       _os_.marshal(this.issendtip);
/*  943 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  949 */       this.auctionroleid = _os_.unmarshal_long();
/*  950 */       this.endtime = _os_.unmarshal_long();
/*  951 */       this.auctioncount = _os_.unmarshal_int();
/*  952 */       this.auctionprice = _os_.unmarshal_int();
/*  953 */       this.itemid = _os_.unmarshal_int();
/*  954 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  956 */         long _v_ = 0L;
/*  957 */         _v_ = _os_.unmarshal_long();
/*  958 */         this.auctionroleset.add(Long.valueOf(_v_));
/*      */       }
/*  960 */       this.itemnum = _os_.unmarshal_int();
/*  961 */       this.issendtip = _os_.unmarshal_boolean();
/*  962 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  968 */       int _size_ = 0;
/*  969 */       _size_ += CodedOutputStream.computeInt64Size(1, this.auctionroleid);
/*  970 */       _size_ += CodedOutputStream.computeInt64Size(2, this.endtime);
/*  971 */       _size_ += CodedOutputStream.computeInt32Size(3, this.auctioncount);
/*  972 */       _size_ += CodedOutputStream.computeInt32Size(4, this.auctionprice);
/*  973 */       _size_ += CodedOutputStream.computeInt32Size(5, this.itemid);
/*  974 */       for (Long _v_ : this.auctionroleset)
/*      */       {
/*  976 */         _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */       }
/*  978 */       _size_ += CodedOutputStream.computeInt32Size(7, this.itemnum);
/*  979 */       _size_ += CodedOutputStream.computeBoolSize(8, this.issendtip);
/*  980 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  988 */         _output_.writeInt64(1, this.auctionroleid);
/*  989 */         _output_.writeInt64(2, this.endtime);
/*  990 */         _output_.writeInt32(3, this.auctioncount);
/*  991 */         _output_.writeInt32(4, this.auctionprice);
/*  992 */         _output_.writeInt32(5, this.itemid);
/*  993 */         for (Long _v_ : this.auctionroleset)
/*      */         {
/*  995 */           _output_.writeInt64(6, _v_.longValue());
/*      */         }
/*  997 */         _output_.writeInt32(7, this.itemnum);
/*  998 */         _output_.writeBool(8, this.issendtip);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1002 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1004 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1012 */         boolean done = false;
/* 1013 */         while (!done)
/*      */         {
/* 1015 */           int tag = _input_.readTag();
/* 1016 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1020 */             done = true;
/* 1021 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1025 */             this.auctionroleid = _input_.readInt64();
/* 1026 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1030 */             this.endtime = _input_.readInt64();
/* 1031 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1035 */             this.auctioncount = _input_.readInt32();
/* 1036 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1040 */             this.auctionprice = _input_.readInt32();
/* 1041 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1045 */             this.itemid = _input_.readInt32();
/* 1046 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1050 */             long _v_ = 0L;
/* 1051 */             _v_ = _input_.readInt64();
/* 1052 */             this.auctionroleset.add(Long.valueOf(_v_));
/* 1053 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1057 */             this.itemnum = _input_.readInt32();
/* 1058 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1062 */             this.issendtip = _input_.readBool();
/* 1063 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1067 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1069 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1078 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1082 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1084 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionItemInfo copy()
/*      */     {
/* 1090 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionItemInfo toData()
/*      */     {
/* 1096 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AuctionItemInfo toBean()
/*      */     {
/* 1101 */       return new AuctionItemInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionItemInfo toDataIf()
/*      */     {
/* 1107 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AuctionItemInfo toBeanIf()
/*      */     {
/* 1112 */       return new AuctionItemInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1118 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1122 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1126 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1130 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1134 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1138 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1142 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAuctionroleid()
/*      */     {
/* 1149 */       return this.auctionroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/* 1156 */       return this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAuctioncount()
/*      */     {
/* 1163 */       return this.auctioncount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAuctionprice()
/*      */     {
/* 1170 */       return this.auctionprice;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemid()
/*      */     {
/* 1177 */       return this.itemid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAuctionroleset()
/*      */     {
/* 1184 */       return this.auctionroleset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAuctionrolesetAsData()
/*      */     {
/* 1191 */       return this.auctionroleset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemnum()
/*      */     {
/* 1198 */       return this.itemnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIssendtip()
/*      */     {
/* 1205 */       return this.issendtip;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctionroleid(long _v_)
/*      */     {
/* 1212 */       this.auctionroleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/* 1219 */       this.endtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctioncount(int _v_)
/*      */     {
/* 1226 */       this.auctioncount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctionprice(int _v_)
/*      */     {
/* 1233 */       this.auctionprice = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemid(int _v_)
/*      */     {
/* 1240 */       this.itemid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemnum(int _v_)
/*      */     {
/* 1247 */       this.itemnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIssendtip(boolean _v_)
/*      */     {
/* 1254 */       this.issendtip = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1260 */       if (!(_o1_ instanceof Data)) return false;
/* 1261 */       Data _o_ = (Data)_o1_;
/* 1262 */       if (this.auctionroleid != _o_.auctionroleid) return false;
/* 1263 */       if (this.endtime != _o_.endtime) return false;
/* 1264 */       if (this.auctioncount != _o_.auctioncount) return false;
/* 1265 */       if (this.auctionprice != _o_.auctionprice) return false;
/* 1266 */       if (this.itemid != _o_.itemid) return false;
/* 1267 */       if (!this.auctionroleset.equals(_o_.auctionroleset)) return false;
/* 1268 */       if (this.itemnum != _o_.itemnum) return false;
/* 1269 */       if (this.issendtip != _o_.issendtip) return false;
/* 1270 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1276 */       int _h_ = 0;
/* 1277 */       _h_ = (int)(_h_ + this.auctionroleid);
/* 1278 */       _h_ = (int)(_h_ + this.endtime);
/* 1279 */       _h_ += this.auctioncount;
/* 1280 */       _h_ += this.auctionprice;
/* 1281 */       _h_ += this.itemid;
/* 1282 */       _h_ += this.auctionroleset.hashCode();
/* 1283 */       _h_ += this.itemnum;
/* 1284 */       _h_ += (this.issendtip ? 1231 : 1237);
/* 1285 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1291 */       StringBuilder _sb_ = new StringBuilder();
/* 1292 */       _sb_.append("(");
/* 1293 */       _sb_.append(this.auctionroleid);
/* 1294 */       _sb_.append(",");
/* 1295 */       _sb_.append(this.endtime);
/* 1296 */       _sb_.append(",");
/* 1297 */       _sb_.append(this.auctioncount);
/* 1298 */       _sb_.append(",");
/* 1299 */       _sb_.append(this.auctionprice);
/* 1300 */       _sb_.append(",");
/* 1301 */       _sb_.append(this.itemid);
/* 1302 */       _sb_.append(",");
/* 1303 */       _sb_.append(this.auctionroleset);
/* 1304 */       _sb_.append(",");
/* 1305 */       _sb_.append(this.itemnum);
/* 1306 */       _sb_.append(",");
/* 1307 */       _sb_.append(this.issendtip);
/* 1308 */       _sb_.append(")");
/* 1309 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AuctionItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */