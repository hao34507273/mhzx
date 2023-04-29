/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class AuctionRefundInfo extends XBean implements xbean.AuctionRefundInfo
/*      */ {
/*      */   private long activityperiodstarttimestamp;
/*      */   private long activityperiodendtimestamp;
/*      */   private int turnindex;
/*      */   private long turnstarttimestamp;
/*      */   private long turnendtimestamp;
/*      */   private int itemcfgid;
/*      */   private long moneycount;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.activityperiodstarttimestamp = 0L;
/*   31 */     this.activityperiodendtimestamp = 0L;
/*   32 */     this.turnindex = 0;
/*   33 */     this.turnstarttimestamp = 0L;
/*   34 */     this.turnendtimestamp = 0L;
/*   35 */     this.itemcfgid = 0;
/*   36 */     this.moneycount = 0L;
/*      */   }
/*      */   
/*      */   AuctionRefundInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*      */   }
/*      */   
/*      */   public AuctionRefundInfo()
/*      */   {
/*   46 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AuctionRefundInfo(AuctionRefundInfo _o_)
/*      */   {
/*   51 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AuctionRefundInfo(xbean.AuctionRefundInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     if ((_o1_ instanceof AuctionRefundInfo)) { assign((AuctionRefundInfo)_o1_);
/*   58 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   59 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   60 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AuctionRefundInfo _o_) {
/*   65 */     _o_._xdb_verify_unsafe_();
/*   66 */     this.activityperiodstarttimestamp = _o_.activityperiodstarttimestamp;
/*   67 */     this.activityperiodendtimestamp = _o_.activityperiodendtimestamp;
/*   68 */     this.turnindex = _o_.turnindex;
/*   69 */     this.turnstarttimestamp = _o_.turnstarttimestamp;
/*   70 */     this.turnendtimestamp = _o_.turnendtimestamp;
/*   71 */     this.itemcfgid = _o_.itemcfgid;
/*   72 */     this.moneycount = _o_.moneycount;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   77 */     this.activityperiodstarttimestamp = _o_.activityperiodstarttimestamp;
/*   78 */     this.activityperiodendtimestamp = _o_.activityperiodendtimestamp;
/*   79 */     this.turnindex = _o_.turnindex;
/*   80 */     this.turnstarttimestamp = _o_.turnstarttimestamp;
/*   81 */     this.turnendtimestamp = _o_.turnendtimestamp;
/*   82 */     this.itemcfgid = _o_.itemcfgid;
/*   83 */     this.moneycount = _o_.moneycount;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   89 */     _xdb_verify_unsafe_();
/*   90 */     _os_.marshal(this.activityperiodstarttimestamp);
/*   91 */     _os_.marshal(this.activityperiodendtimestamp);
/*   92 */     _os_.marshal(this.turnindex);
/*   93 */     _os_.marshal(this.turnstarttimestamp);
/*   94 */     _os_.marshal(this.turnendtimestamp);
/*   95 */     _os_.marshal(this.itemcfgid);
/*   96 */     _os_.marshal(this.moneycount);
/*   97 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     this.activityperiodstarttimestamp = _os_.unmarshal_long();
/*  105 */     this.activityperiodendtimestamp = _os_.unmarshal_long();
/*  106 */     this.turnindex = _os_.unmarshal_int();
/*  107 */     this.turnstarttimestamp = _os_.unmarshal_long();
/*  108 */     this.turnendtimestamp = _os_.unmarshal_long();
/*  109 */     this.itemcfgid = _os_.unmarshal_int();
/*  110 */     this.moneycount = _os_.unmarshal_long();
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*  118 */     int _size_ = 0;
/*  119 */     _size_ += CodedOutputStream.computeInt64Size(1, this.activityperiodstarttimestamp);
/*  120 */     _size_ += CodedOutputStream.computeInt64Size(2, this.activityperiodendtimestamp);
/*  121 */     _size_ += CodedOutputStream.computeInt32Size(3, this.turnindex);
/*  122 */     _size_ += CodedOutputStream.computeInt64Size(4, this.turnstarttimestamp);
/*  123 */     _size_ += CodedOutputStream.computeInt64Size(5, this.turnendtimestamp);
/*  124 */     _size_ += CodedOutputStream.computeInt32Size(6, this.itemcfgid);
/*  125 */     _size_ += CodedOutputStream.computeInt64Size(7, this.moneycount);
/*  126 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  132 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  135 */       _output_.writeInt64(1, this.activityperiodstarttimestamp);
/*  136 */       _output_.writeInt64(2, this.activityperiodendtimestamp);
/*  137 */       _output_.writeInt32(3, this.turnindex);
/*  138 */       _output_.writeInt64(4, this.turnstarttimestamp);
/*  139 */       _output_.writeInt64(5, this.turnendtimestamp);
/*  140 */       _output_.writeInt32(6, this.itemcfgid);
/*  141 */       _output_.writeInt64(7, this.moneycount);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  145 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  147 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  153 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  156 */       boolean done = false;
/*  157 */       while (!done)
/*      */       {
/*  159 */         int tag = _input_.readTag();
/*  160 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  164 */           done = true;
/*  165 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  169 */           this.activityperiodstarttimestamp = _input_.readInt64();
/*  170 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  174 */           this.activityperiodendtimestamp = _input_.readInt64();
/*  175 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  179 */           this.turnindex = _input_.readInt32();
/*  180 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  184 */           this.turnstarttimestamp = _input_.readInt64();
/*  185 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  189 */           this.turnendtimestamp = _input_.readInt64();
/*  190 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  194 */           this.itemcfgid = _input_.readInt32();
/*  195 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  199 */           this.moneycount = _input_.readInt64();
/*  200 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  204 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  206 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  215 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  219 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  221 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AuctionRefundInfo copy()
/*      */   {
/*  227 */     _xdb_verify_unsafe_();
/*  228 */     return new AuctionRefundInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AuctionRefundInfo toData()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AuctionRefundInfo toBean()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return new AuctionRefundInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AuctionRefundInfo toDataIf()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AuctionRefundInfo toBeanIf()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getActivityperiodstarttimestamp()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return this.activityperiodstarttimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getActivityperiodendtimestamp()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return this.activityperiodendtimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTurnindex()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return this.turnindex;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTurnstarttimestamp()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return this.turnstarttimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTurnendtimestamp()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this.turnendtimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItemcfgid()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return this.itemcfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMoneycount()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return this.moneycount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivityperiodstarttimestamp(long _v_)
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     Logs.logIf(new LogKey(this, "activityperiodstarttimestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  329 */         new LogLong(this, AuctionRefundInfo.this.activityperiodstarttimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  333 */             AuctionRefundInfo.this.activityperiodstarttimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  337 */     });
/*  338 */     this.activityperiodstarttimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivityperiodendtimestamp(long _v_)
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     Logs.logIf(new LogKey(this, "activityperiodendtimestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  350 */         new LogLong(this, AuctionRefundInfo.this.activityperiodendtimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  354 */             AuctionRefundInfo.this.activityperiodendtimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  358 */     });
/*  359 */     this.activityperiodendtimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTurnindex(int _v_)
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     Logs.logIf(new LogKey(this, "turnindex")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  371 */         new LogInt(this, AuctionRefundInfo.this.turnindex)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  375 */             AuctionRefundInfo.this.turnindex = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  379 */     });
/*  380 */     this.turnindex = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTurnstarttimestamp(long _v_)
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     Logs.logIf(new LogKey(this, "turnstarttimestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  392 */         new LogLong(this, AuctionRefundInfo.this.turnstarttimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  396 */             AuctionRefundInfo.this.turnstarttimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  400 */     });
/*  401 */     this.turnstarttimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTurnendtimestamp(long _v_)
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     Logs.logIf(new LogKey(this, "turnendtimestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  413 */         new LogLong(this, AuctionRefundInfo.this.turnendtimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  417 */             AuctionRefundInfo.this.turnendtimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  421 */     });
/*  422 */     this.turnendtimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItemcfgid(int _v_)
/*      */   {
/*  429 */     _xdb_verify_unsafe_();
/*  430 */     Logs.logIf(new LogKey(this, "itemcfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  434 */         new LogInt(this, AuctionRefundInfo.this.itemcfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  438 */             AuctionRefundInfo.this.itemcfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  442 */     });
/*  443 */     this.itemcfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMoneycount(long _v_)
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     Logs.logIf(new LogKey(this, "moneycount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  455 */         new LogLong(this, AuctionRefundInfo.this.moneycount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  459 */             AuctionRefundInfo.this.moneycount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  463 */     });
/*  464 */     this.moneycount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  470 */     _xdb_verify_unsafe_();
/*  471 */     AuctionRefundInfo _o_ = null;
/*  472 */     if ((_o1_ instanceof AuctionRefundInfo)) { _o_ = (AuctionRefundInfo)_o1_;
/*  473 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  474 */       return false;
/*  475 */     if (this.activityperiodstarttimestamp != _o_.activityperiodstarttimestamp) return false;
/*  476 */     if (this.activityperiodendtimestamp != _o_.activityperiodendtimestamp) return false;
/*  477 */     if (this.turnindex != _o_.turnindex) return false;
/*  478 */     if (this.turnstarttimestamp != _o_.turnstarttimestamp) return false;
/*  479 */     if (this.turnendtimestamp != _o_.turnendtimestamp) return false;
/*  480 */     if (this.itemcfgid != _o_.itemcfgid) return false;
/*  481 */     if (this.moneycount != _o_.moneycount) return false;
/*  482 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  488 */     _xdb_verify_unsafe_();
/*  489 */     int _h_ = 0;
/*  490 */     _h_ = (int)(_h_ + this.activityperiodstarttimestamp);
/*  491 */     _h_ = (int)(_h_ + this.activityperiodendtimestamp);
/*  492 */     _h_ += this.turnindex;
/*  493 */     _h_ = (int)(_h_ + this.turnstarttimestamp);
/*  494 */     _h_ = (int)(_h_ + this.turnendtimestamp);
/*  495 */     _h_ += this.itemcfgid;
/*  496 */     _h_ = (int)(_h_ + this.moneycount);
/*  497 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     StringBuilder _sb_ = new StringBuilder();
/*  505 */     _sb_.append("(");
/*  506 */     _sb_.append(this.activityperiodstarttimestamp);
/*  507 */     _sb_.append(",");
/*  508 */     _sb_.append(this.activityperiodendtimestamp);
/*  509 */     _sb_.append(",");
/*  510 */     _sb_.append(this.turnindex);
/*  511 */     _sb_.append(",");
/*  512 */     _sb_.append(this.turnstarttimestamp);
/*  513 */     _sb_.append(",");
/*  514 */     _sb_.append(this.turnendtimestamp);
/*  515 */     _sb_.append(",");
/*  516 */     _sb_.append(this.itemcfgid);
/*  517 */     _sb_.append(",");
/*  518 */     _sb_.append(this.moneycount);
/*  519 */     _sb_.append(")");
/*  520 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  526 */     ListenableBean lb = new ListenableBean();
/*  527 */     lb.add(new ListenableChanged().setVarName("activityperiodstarttimestamp"));
/*  528 */     lb.add(new ListenableChanged().setVarName("activityperiodendtimestamp"));
/*  529 */     lb.add(new ListenableChanged().setVarName("turnindex"));
/*  530 */     lb.add(new ListenableChanged().setVarName("turnstarttimestamp"));
/*  531 */     lb.add(new ListenableChanged().setVarName("turnendtimestamp"));
/*  532 */     lb.add(new ListenableChanged().setVarName("itemcfgid"));
/*  533 */     lb.add(new ListenableChanged().setVarName("moneycount"));
/*  534 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AuctionRefundInfo {
/*      */     private Const() {}
/*      */     
/*      */     AuctionRefundInfo nThis() {
/*  541 */       return AuctionRefundInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  547 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionRefundInfo copy()
/*      */     {
/*  553 */       return AuctionRefundInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionRefundInfo toData()
/*      */     {
/*  559 */       return AuctionRefundInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AuctionRefundInfo toBean()
/*      */     {
/*  564 */       return AuctionRefundInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionRefundInfo toDataIf()
/*      */     {
/*  570 */       return AuctionRefundInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AuctionRefundInfo toBeanIf()
/*      */     {
/*  575 */       return AuctionRefundInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getActivityperiodstarttimestamp()
/*      */     {
/*  582 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  583 */       return AuctionRefundInfo.this.activityperiodstarttimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getActivityperiodendtimestamp()
/*      */     {
/*  590 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  591 */       return AuctionRefundInfo.this.activityperiodendtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTurnindex()
/*      */     {
/*  598 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  599 */       return AuctionRefundInfo.this.turnindex;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTurnstarttimestamp()
/*      */     {
/*  606 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  607 */       return AuctionRefundInfo.this.turnstarttimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTurnendtimestamp()
/*      */     {
/*  614 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  615 */       return AuctionRefundInfo.this.turnendtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemcfgid()
/*      */     {
/*  622 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  623 */       return AuctionRefundInfo.this.itemcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMoneycount()
/*      */     {
/*  630 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  631 */       return AuctionRefundInfo.this.moneycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivityperiodstarttimestamp(long _v_)
/*      */     {
/*  638 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  639 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivityperiodendtimestamp(long _v_)
/*      */     {
/*  646 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  647 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTurnindex(int _v_)
/*      */     {
/*  654 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  655 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTurnstarttimestamp(long _v_)
/*      */     {
/*  662 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  663 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTurnendtimestamp(long _v_)
/*      */     {
/*  670 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  671 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemcfgid(int _v_)
/*      */     {
/*  678 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  679 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMoneycount(long _v_)
/*      */     {
/*  686 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  687 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  693 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  694 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  700 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  701 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  707 */       return AuctionRefundInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  713 */       return AuctionRefundInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  719 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  720 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  726 */       return AuctionRefundInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  732 */       return AuctionRefundInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  738 */       AuctionRefundInfo.this._xdb_verify_unsafe_();
/*  739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  745 */       return AuctionRefundInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  751 */       return AuctionRefundInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  757 */       return AuctionRefundInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  763 */       return AuctionRefundInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  769 */       return AuctionRefundInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  775 */       return AuctionRefundInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  781 */       return AuctionRefundInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AuctionRefundInfo
/*      */   {
/*      */     private long activityperiodstarttimestamp;
/*      */     
/*      */     private long activityperiodendtimestamp;
/*      */     
/*      */     private int turnindex;
/*      */     
/*      */     private long turnstarttimestamp;
/*      */     
/*      */     private long turnendtimestamp;
/*      */     
/*      */     private int itemcfgid;
/*      */     
/*      */     private long moneycount;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  805 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Data() {}
/*      */     
/*      */ 
/*      */     Data(xbean.AuctionRefundInfo _o1_)
/*      */     {
/*  814 */       if ((_o1_ instanceof AuctionRefundInfo)) { assign((AuctionRefundInfo)_o1_);
/*  815 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  816 */       } else if ((_o1_ instanceof AuctionRefundInfo.Const)) assign(((AuctionRefundInfo.Const)_o1_).nThis()); else {
/*  817 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AuctionRefundInfo _o_) {
/*  822 */       this.activityperiodstarttimestamp = _o_.activityperiodstarttimestamp;
/*  823 */       this.activityperiodendtimestamp = _o_.activityperiodendtimestamp;
/*  824 */       this.turnindex = _o_.turnindex;
/*  825 */       this.turnstarttimestamp = _o_.turnstarttimestamp;
/*  826 */       this.turnendtimestamp = _o_.turnendtimestamp;
/*  827 */       this.itemcfgid = _o_.itemcfgid;
/*  828 */       this.moneycount = _o_.moneycount;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  833 */       this.activityperiodstarttimestamp = _o_.activityperiodstarttimestamp;
/*  834 */       this.activityperiodendtimestamp = _o_.activityperiodendtimestamp;
/*  835 */       this.turnindex = _o_.turnindex;
/*  836 */       this.turnstarttimestamp = _o_.turnstarttimestamp;
/*  837 */       this.turnendtimestamp = _o_.turnendtimestamp;
/*  838 */       this.itemcfgid = _o_.itemcfgid;
/*  839 */       this.moneycount = _o_.moneycount;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  845 */       _os_.marshal(this.activityperiodstarttimestamp);
/*  846 */       _os_.marshal(this.activityperiodendtimestamp);
/*  847 */       _os_.marshal(this.turnindex);
/*  848 */       _os_.marshal(this.turnstarttimestamp);
/*  849 */       _os_.marshal(this.turnendtimestamp);
/*  850 */       _os_.marshal(this.itemcfgid);
/*  851 */       _os_.marshal(this.moneycount);
/*  852 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  858 */       this.activityperiodstarttimestamp = _os_.unmarshal_long();
/*  859 */       this.activityperiodendtimestamp = _os_.unmarshal_long();
/*  860 */       this.turnindex = _os_.unmarshal_int();
/*  861 */       this.turnstarttimestamp = _os_.unmarshal_long();
/*  862 */       this.turnendtimestamp = _os_.unmarshal_long();
/*  863 */       this.itemcfgid = _os_.unmarshal_int();
/*  864 */       this.moneycount = _os_.unmarshal_long();
/*  865 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  871 */       int _size_ = 0;
/*  872 */       _size_ += CodedOutputStream.computeInt64Size(1, this.activityperiodstarttimestamp);
/*  873 */       _size_ += CodedOutputStream.computeInt64Size(2, this.activityperiodendtimestamp);
/*  874 */       _size_ += CodedOutputStream.computeInt32Size(3, this.turnindex);
/*  875 */       _size_ += CodedOutputStream.computeInt64Size(4, this.turnstarttimestamp);
/*  876 */       _size_ += CodedOutputStream.computeInt64Size(5, this.turnendtimestamp);
/*  877 */       _size_ += CodedOutputStream.computeInt32Size(6, this.itemcfgid);
/*  878 */       _size_ += CodedOutputStream.computeInt64Size(7, this.moneycount);
/*  879 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  887 */         _output_.writeInt64(1, this.activityperiodstarttimestamp);
/*  888 */         _output_.writeInt64(2, this.activityperiodendtimestamp);
/*  889 */         _output_.writeInt32(3, this.turnindex);
/*  890 */         _output_.writeInt64(4, this.turnstarttimestamp);
/*  891 */         _output_.writeInt64(5, this.turnendtimestamp);
/*  892 */         _output_.writeInt32(6, this.itemcfgid);
/*  893 */         _output_.writeInt64(7, this.moneycount);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  897 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  899 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  907 */         boolean done = false;
/*  908 */         while (!done)
/*      */         {
/*  910 */           int tag = _input_.readTag();
/*  911 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  915 */             done = true;
/*  916 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  920 */             this.activityperiodstarttimestamp = _input_.readInt64();
/*  921 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  925 */             this.activityperiodendtimestamp = _input_.readInt64();
/*  926 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  930 */             this.turnindex = _input_.readInt32();
/*  931 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  935 */             this.turnstarttimestamp = _input_.readInt64();
/*  936 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  940 */             this.turnendtimestamp = _input_.readInt64();
/*  941 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  945 */             this.itemcfgid = _input_.readInt32();
/*  946 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/*  950 */             this.moneycount = _input_.readInt64();
/*  951 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  955 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  957 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  966 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  970 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  972 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionRefundInfo copy()
/*      */     {
/*  978 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionRefundInfo toData()
/*      */     {
/*  984 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AuctionRefundInfo toBean()
/*      */     {
/*  989 */       return new AuctionRefundInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionRefundInfo toDataIf()
/*      */     {
/*  995 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AuctionRefundInfo toBeanIf()
/*      */     {
/* 1000 */       return new AuctionRefundInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1006 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1010 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1014 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1018 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1022 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1026 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1030 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getActivityperiodstarttimestamp()
/*      */     {
/* 1037 */       return this.activityperiodstarttimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getActivityperiodendtimestamp()
/*      */     {
/* 1044 */       return this.activityperiodendtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTurnindex()
/*      */     {
/* 1051 */       return this.turnindex;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTurnstarttimestamp()
/*      */     {
/* 1058 */       return this.turnstarttimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTurnendtimestamp()
/*      */     {
/* 1065 */       return this.turnendtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemcfgid()
/*      */     {
/* 1072 */       return this.itemcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMoneycount()
/*      */     {
/* 1079 */       return this.moneycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivityperiodstarttimestamp(long _v_)
/*      */     {
/* 1086 */       this.activityperiodstarttimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivityperiodendtimestamp(long _v_)
/*      */     {
/* 1093 */       this.activityperiodendtimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTurnindex(int _v_)
/*      */     {
/* 1100 */       this.turnindex = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTurnstarttimestamp(long _v_)
/*      */     {
/* 1107 */       this.turnstarttimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTurnendtimestamp(long _v_)
/*      */     {
/* 1114 */       this.turnendtimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemcfgid(int _v_)
/*      */     {
/* 1121 */       this.itemcfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMoneycount(long _v_)
/*      */     {
/* 1128 */       this.moneycount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1134 */       if (!(_o1_ instanceof Data)) return false;
/* 1135 */       Data _o_ = (Data)_o1_;
/* 1136 */       if (this.activityperiodstarttimestamp != _o_.activityperiodstarttimestamp) return false;
/* 1137 */       if (this.activityperiodendtimestamp != _o_.activityperiodendtimestamp) return false;
/* 1138 */       if (this.turnindex != _o_.turnindex) return false;
/* 1139 */       if (this.turnstarttimestamp != _o_.turnstarttimestamp) return false;
/* 1140 */       if (this.turnendtimestamp != _o_.turnendtimestamp) return false;
/* 1141 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/* 1142 */       if (this.moneycount != _o_.moneycount) return false;
/* 1143 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1149 */       int _h_ = 0;
/* 1150 */       _h_ = (int)(_h_ + this.activityperiodstarttimestamp);
/* 1151 */       _h_ = (int)(_h_ + this.activityperiodendtimestamp);
/* 1152 */       _h_ += this.turnindex;
/* 1153 */       _h_ = (int)(_h_ + this.turnstarttimestamp);
/* 1154 */       _h_ = (int)(_h_ + this.turnendtimestamp);
/* 1155 */       _h_ += this.itemcfgid;
/* 1156 */       _h_ = (int)(_h_ + this.moneycount);
/* 1157 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1163 */       StringBuilder _sb_ = new StringBuilder();
/* 1164 */       _sb_.append("(");
/* 1165 */       _sb_.append(this.activityperiodstarttimestamp);
/* 1166 */       _sb_.append(",");
/* 1167 */       _sb_.append(this.activityperiodendtimestamp);
/* 1168 */       _sb_.append(",");
/* 1169 */       _sb_.append(this.turnindex);
/* 1170 */       _sb_.append(",");
/* 1171 */       _sb_.append(this.turnstarttimestamp);
/* 1172 */       _sb_.append(",");
/* 1173 */       _sb_.append(this.turnendtimestamp);
/* 1174 */       _sb_.append(",");
/* 1175 */       _sb_.append(this.itemcfgid);
/* 1176 */       _sb_.append(",");
/* 1177 */       _sb_.append(this.moneycount);
/* 1178 */       _sb_.append(")");
/* 1179 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AuctionRefundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */