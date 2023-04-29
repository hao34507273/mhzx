/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class XiaoHuiKuaiPaoInfo extends XBean implements xbean.XiaoHuiKuaiPaoInfo
/*      */ {
/*      */   private int index;
/*      */   private int accumulateturncount;
/*      */   private int ticketcount;
/*      */   private SetX<Integer> hitindexes;
/*      */   private SetX<Integer> hitrandomtexttabletypeids;
/*      */   private long endtimestamp;
/*      */   private int isouterturnconverttopoint;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.index = 0;
/*   31 */     this.accumulateturncount = 0;
/*   32 */     this.ticketcount = 0;
/*   33 */     this.hitindexes.clear();
/*   34 */     this.hitrandomtexttabletypeids.clear();
/*   35 */     this.endtimestamp = 0L;
/*   36 */     this.isouterturnconverttopoint = 0;
/*      */   }
/*      */   
/*      */   XiaoHuiKuaiPaoInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.hitindexes = new SetX();
/*   43 */     this.hitrandomtexttabletypeids = new SetX();
/*      */   }
/*      */   
/*      */   public XiaoHuiKuaiPaoInfo()
/*      */   {
/*   48 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public XiaoHuiKuaiPaoInfo(XiaoHuiKuaiPaoInfo _o_)
/*      */   {
/*   53 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   XiaoHuiKuaiPaoInfo(xbean.XiaoHuiKuaiPaoInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   58 */     super(_xp_, _vn_);
/*   59 */     if ((_o1_ instanceof XiaoHuiKuaiPaoInfo)) { assign((XiaoHuiKuaiPaoInfo)_o1_);
/*   60 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   61 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   62 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(XiaoHuiKuaiPaoInfo _o_) {
/*   67 */     _o_._xdb_verify_unsafe_();
/*   68 */     this.index = _o_.index;
/*   69 */     this.accumulateturncount = _o_.accumulateturncount;
/*   70 */     this.ticketcount = _o_.ticketcount;
/*   71 */     this.hitindexes = new SetX();
/*   72 */     this.hitindexes.addAll(_o_.hitindexes);
/*   73 */     this.hitrandomtexttabletypeids = new SetX();
/*   74 */     this.hitrandomtexttabletypeids.addAll(_o_.hitrandomtexttabletypeids);
/*   75 */     this.endtimestamp = _o_.endtimestamp;
/*   76 */     this.isouterturnconverttopoint = _o_.isouterturnconverttopoint;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   81 */     this.index = _o_.index;
/*   82 */     this.accumulateturncount = _o_.accumulateturncount;
/*   83 */     this.ticketcount = _o_.ticketcount;
/*   84 */     this.hitindexes = new SetX();
/*   85 */     this.hitindexes.addAll(_o_.hitindexes);
/*   86 */     this.hitrandomtexttabletypeids = new SetX();
/*   87 */     this.hitrandomtexttabletypeids.addAll(_o_.hitrandomtexttabletypeids);
/*   88 */     this.endtimestamp = _o_.endtimestamp;
/*   89 */     this.isouterturnconverttopoint = _o_.isouterturnconverttopoint;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   95 */     _xdb_verify_unsafe_();
/*   96 */     _os_.marshal(this.index);
/*   97 */     _os_.marshal(this.accumulateturncount);
/*   98 */     _os_.marshal(this.ticketcount);
/*   99 */     _os_.compact_uint32(this.hitindexes.size());
/*  100 */     for (Integer _v_ : this.hitindexes)
/*      */     {
/*  102 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  104 */     _os_.compact_uint32(this.hitrandomtexttabletypeids.size());
/*  105 */     for (Integer _v_ : this.hitrandomtexttabletypeids)
/*      */     {
/*  107 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  109 */     _os_.marshal(this.endtimestamp);
/*  110 */     _os_.marshal(this.isouterturnconverttopoint);
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*  118 */     this.index = _os_.unmarshal_int();
/*  119 */     this.accumulateturncount = _os_.unmarshal_int();
/*  120 */     this.ticketcount = _os_.unmarshal_int();
/*  121 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  123 */       int _v_ = 0;
/*  124 */       _v_ = _os_.unmarshal_int();
/*  125 */       this.hitindexes.add(Integer.valueOf(_v_));
/*      */     }
/*  127 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  129 */       int _v_ = 0;
/*  130 */       _v_ = _os_.unmarshal_int();
/*  131 */       this.hitrandomtexttabletypeids.add(Integer.valueOf(_v_));
/*      */     }
/*  133 */     this.endtimestamp = _os_.unmarshal_long();
/*  134 */     this.isouterturnconverttopoint = _os_.unmarshal_int();
/*  135 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  141 */     _xdb_verify_unsafe_();
/*  142 */     int _size_ = 0;
/*  143 */     _size_ += CodedOutputStream.computeInt32Size(1, this.index);
/*  144 */     _size_ += CodedOutputStream.computeInt32Size(2, this.accumulateturncount);
/*  145 */     _size_ += CodedOutputStream.computeInt32Size(3, this.ticketcount);
/*  146 */     for (Integer _v_ : this.hitindexes)
/*      */     {
/*  148 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */     }
/*  150 */     for (Integer _v_ : this.hitrandomtexttabletypeids)
/*      */     {
/*  152 */       _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */     }
/*  154 */     _size_ += CodedOutputStream.computeInt64Size(6, this.endtimestamp);
/*  155 */     _size_ += CodedOutputStream.computeInt32Size(7, this.isouterturnconverttopoint);
/*  156 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  165 */       _output_.writeInt32(1, this.index);
/*  166 */       _output_.writeInt32(2, this.accumulateturncount);
/*  167 */       _output_.writeInt32(3, this.ticketcount);
/*  168 */       for (Integer _v_ : this.hitindexes)
/*      */       {
/*  170 */         _output_.writeInt32(4, _v_.intValue());
/*      */       }
/*  172 */       for (Integer _v_ : this.hitrandomtexttabletypeids)
/*      */       {
/*  174 */         _output_.writeInt32(5, _v_.intValue());
/*      */       }
/*  176 */       _output_.writeInt64(6, this.endtimestamp);
/*  177 */       _output_.writeInt32(7, this.isouterturnconverttopoint);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  181 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  183 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  189 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  192 */       boolean done = false;
/*  193 */       while (!done)
/*      */       {
/*  195 */         int tag = _input_.readTag();
/*  196 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  200 */           done = true;
/*  201 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  205 */           this.index = _input_.readInt32();
/*  206 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  210 */           this.accumulateturncount = _input_.readInt32();
/*  211 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  215 */           this.ticketcount = _input_.readInt32();
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  220 */           int _v_ = 0;
/*  221 */           _v_ = _input_.readInt32();
/*  222 */           this.hitindexes.add(Integer.valueOf(_v_));
/*  223 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  227 */           int _v_ = 0;
/*  228 */           _v_ = _input_.readInt32();
/*  229 */           this.hitrandomtexttabletypeids.add(Integer.valueOf(_v_));
/*  230 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  234 */           this.endtimestamp = _input_.readInt64();
/*  235 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  239 */           this.isouterturnconverttopoint = _input_.readInt32();
/*  240 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  244 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  246 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  255 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  259 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  261 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.XiaoHuiKuaiPaoInfo copy()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new XiaoHuiKuaiPaoInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.XiaoHuiKuaiPaoInfo toData()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.XiaoHuiKuaiPaoInfo toBean()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return new XiaoHuiKuaiPaoInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.XiaoHuiKuaiPaoInfo toDataIf()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.XiaoHuiKuaiPaoInfo toBeanIf()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getIndex()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return this.index;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAccumulateturncount()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return this.accumulateturncount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTicketcount()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return this.ticketcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getHitindexes()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return Logs.logSet(new LogKey(this, "hitindexes"), this.hitindexes);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getHitindexesAsData()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*      */     
/*  341 */     XiaoHuiKuaiPaoInfo _o_ = this;
/*  342 */     Set<Integer> hitindexes = new SetX();
/*  343 */     hitindexes.addAll(_o_.hitindexes);
/*  344 */     return hitindexes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getHitrandomtexttabletypeids()
/*      */   {
/*  351 */     _xdb_verify_unsafe_();
/*  352 */     return Logs.logSet(new LogKey(this, "hitrandomtexttabletypeids"), this.hitrandomtexttabletypeids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getHitrandomtexttabletypeidsAsData()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*      */     
/*  360 */     XiaoHuiKuaiPaoInfo _o_ = this;
/*  361 */     Set<Integer> hitrandomtexttabletypeids = new SetX();
/*  362 */     hitrandomtexttabletypeids.addAll(_o_.hitrandomtexttabletypeids);
/*  363 */     return hitrandomtexttabletypeids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEndtimestamp()
/*      */   {
/*  370 */     _xdb_verify_unsafe_();
/*  371 */     return this.endtimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getIsouterturnconverttopoint()
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     return this.isouterturnconverttopoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIndex(int _v_)
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     Logs.logIf(new LogKey(this, "index")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  391 */         new LogInt(this, XiaoHuiKuaiPaoInfo.this.index)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  395 */             XiaoHuiKuaiPaoInfo.this.index = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  399 */     });
/*  400 */     this.index = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAccumulateturncount(int _v_)
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     Logs.logIf(new LogKey(this, "accumulateturncount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  412 */         new LogInt(this, XiaoHuiKuaiPaoInfo.this.accumulateturncount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  416 */             XiaoHuiKuaiPaoInfo.this.accumulateturncount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  420 */     });
/*  421 */     this.accumulateturncount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTicketcount(int _v_)
/*      */   {
/*  428 */     _xdb_verify_unsafe_();
/*  429 */     Logs.logIf(new LogKey(this, "ticketcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  433 */         new LogInt(this, XiaoHuiKuaiPaoInfo.this.ticketcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  437 */             XiaoHuiKuaiPaoInfo.this.ticketcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  441 */     });
/*  442 */     this.ticketcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEndtimestamp(long _v_)
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*  450 */     Logs.logIf(new LogKey(this, "endtimestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  454 */         new xdb.logs.LogLong(this, XiaoHuiKuaiPaoInfo.this.endtimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  458 */             XiaoHuiKuaiPaoInfo.this.endtimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  462 */     });
/*  463 */     this.endtimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIsouterturnconverttopoint(int _v_)
/*      */   {
/*  470 */     _xdb_verify_unsafe_();
/*  471 */     Logs.logIf(new LogKey(this, "isouterturnconverttopoint")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  475 */         new LogInt(this, XiaoHuiKuaiPaoInfo.this.isouterturnconverttopoint)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  479 */             XiaoHuiKuaiPaoInfo.this.isouterturnconverttopoint = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  483 */     });
/*  484 */     this.isouterturnconverttopoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  490 */     _xdb_verify_unsafe_();
/*  491 */     XiaoHuiKuaiPaoInfo _o_ = null;
/*  492 */     if ((_o1_ instanceof XiaoHuiKuaiPaoInfo)) { _o_ = (XiaoHuiKuaiPaoInfo)_o1_;
/*  493 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  494 */       return false;
/*  495 */     if (this.index != _o_.index) return false;
/*  496 */     if (this.accumulateturncount != _o_.accumulateturncount) return false;
/*  497 */     if (this.ticketcount != _o_.ticketcount) return false;
/*  498 */     if (!this.hitindexes.equals(_o_.hitindexes)) return false;
/*  499 */     if (!this.hitrandomtexttabletypeids.equals(_o_.hitrandomtexttabletypeids)) return false;
/*  500 */     if (this.endtimestamp != _o_.endtimestamp) return false;
/*  501 */     if (this.isouterturnconverttopoint != _o_.isouterturnconverttopoint) return false;
/*  502 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  508 */     _xdb_verify_unsafe_();
/*  509 */     int _h_ = 0;
/*  510 */     _h_ += this.index;
/*  511 */     _h_ += this.accumulateturncount;
/*  512 */     _h_ += this.ticketcount;
/*  513 */     _h_ += this.hitindexes.hashCode();
/*  514 */     _h_ += this.hitrandomtexttabletypeids.hashCode();
/*  515 */     _h_ = (int)(_h_ + this.endtimestamp);
/*  516 */     _h_ += this.isouterturnconverttopoint;
/*  517 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  523 */     _xdb_verify_unsafe_();
/*  524 */     StringBuilder _sb_ = new StringBuilder();
/*  525 */     _sb_.append("(");
/*  526 */     _sb_.append(this.index);
/*  527 */     _sb_.append(",");
/*  528 */     _sb_.append(this.accumulateturncount);
/*  529 */     _sb_.append(",");
/*  530 */     _sb_.append(this.ticketcount);
/*  531 */     _sb_.append(",");
/*  532 */     _sb_.append(this.hitindexes);
/*  533 */     _sb_.append(",");
/*  534 */     _sb_.append(this.hitrandomtexttabletypeids);
/*  535 */     _sb_.append(",");
/*  536 */     _sb_.append(this.endtimestamp);
/*  537 */     _sb_.append(",");
/*  538 */     _sb_.append(this.isouterturnconverttopoint);
/*  539 */     _sb_.append(")");
/*  540 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  546 */     ListenableBean lb = new ListenableBean();
/*  547 */     lb.add(new ListenableChanged().setVarName("index"));
/*  548 */     lb.add(new ListenableChanged().setVarName("accumulateturncount"));
/*  549 */     lb.add(new ListenableChanged().setVarName("ticketcount"));
/*  550 */     lb.add(new xdb.logs.ListenableSet().setVarName("hitindexes"));
/*  551 */     lb.add(new xdb.logs.ListenableSet().setVarName("hitrandomtexttabletypeids"));
/*  552 */     lb.add(new ListenableChanged().setVarName("endtimestamp"));
/*  553 */     lb.add(new ListenableChanged().setVarName("isouterturnconverttopoint"));
/*  554 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.XiaoHuiKuaiPaoInfo {
/*      */     private Const() {}
/*      */     
/*      */     XiaoHuiKuaiPaoInfo nThis() {
/*  561 */       return XiaoHuiKuaiPaoInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  567 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.XiaoHuiKuaiPaoInfo copy()
/*      */     {
/*  573 */       return XiaoHuiKuaiPaoInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.XiaoHuiKuaiPaoInfo toData()
/*      */     {
/*  579 */       return XiaoHuiKuaiPaoInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.XiaoHuiKuaiPaoInfo toBean()
/*      */     {
/*  584 */       return XiaoHuiKuaiPaoInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.XiaoHuiKuaiPaoInfo toDataIf()
/*      */     {
/*  590 */       return XiaoHuiKuaiPaoInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.XiaoHuiKuaiPaoInfo toBeanIf()
/*      */     {
/*  595 */       return XiaoHuiKuaiPaoInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIndex()
/*      */     {
/*  602 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  603 */       return XiaoHuiKuaiPaoInfo.this.index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAccumulateturncount()
/*      */     {
/*  610 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  611 */       return XiaoHuiKuaiPaoInfo.this.accumulateturncount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTicketcount()
/*      */     {
/*  618 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  619 */       return XiaoHuiKuaiPaoInfo.this.ticketcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getHitindexes()
/*      */     {
/*  626 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  627 */       return xdb.Consts.constSet(XiaoHuiKuaiPaoInfo.this.hitindexes);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getHitindexesAsData()
/*      */     {
/*  633 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*      */       
/*  635 */       XiaoHuiKuaiPaoInfo _o_ = XiaoHuiKuaiPaoInfo.this;
/*  636 */       Set<Integer> hitindexes = new SetX();
/*  637 */       hitindexes.addAll(_o_.hitindexes);
/*  638 */       return hitindexes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getHitrandomtexttabletypeids()
/*      */     {
/*  645 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  646 */       return xdb.Consts.constSet(XiaoHuiKuaiPaoInfo.this.hitrandomtexttabletypeids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getHitrandomtexttabletypeidsAsData()
/*      */     {
/*  652 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*      */       
/*  654 */       XiaoHuiKuaiPaoInfo _o_ = XiaoHuiKuaiPaoInfo.this;
/*  655 */       Set<Integer> hitrandomtexttabletypeids = new SetX();
/*  656 */       hitrandomtexttabletypeids.addAll(_o_.hitrandomtexttabletypeids);
/*  657 */       return hitrandomtexttabletypeids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtimestamp()
/*      */     {
/*  664 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  665 */       return XiaoHuiKuaiPaoInfo.this.endtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIsouterturnconverttopoint()
/*      */     {
/*  672 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  673 */       return XiaoHuiKuaiPaoInfo.this.isouterturnconverttopoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIndex(int _v_)
/*      */     {
/*  680 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  681 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAccumulateturncount(int _v_)
/*      */     {
/*  688 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  689 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTicketcount(int _v_)
/*      */     {
/*  696 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  697 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtimestamp(long _v_)
/*      */     {
/*  704 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  705 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsouterturnconverttopoint(int _v_)
/*      */     {
/*  712 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  713 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  719 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  720 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  726 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  727 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  733 */       return XiaoHuiKuaiPaoInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  739 */       return XiaoHuiKuaiPaoInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  745 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  746 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  752 */       return XiaoHuiKuaiPaoInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  758 */       return XiaoHuiKuaiPaoInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  764 */       XiaoHuiKuaiPaoInfo.this._xdb_verify_unsafe_();
/*  765 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  771 */       return XiaoHuiKuaiPaoInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  777 */       return XiaoHuiKuaiPaoInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  783 */       return XiaoHuiKuaiPaoInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  789 */       return XiaoHuiKuaiPaoInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  795 */       return XiaoHuiKuaiPaoInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  801 */       return XiaoHuiKuaiPaoInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  807 */       return XiaoHuiKuaiPaoInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.XiaoHuiKuaiPaoInfo
/*      */   {
/*      */     private int index;
/*      */     
/*      */     private int accumulateturncount;
/*      */     
/*      */     private int ticketcount;
/*      */     
/*      */     private HashSet<Integer> hitindexes;
/*      */     
/*      */     private HashSet<Integer> hitrandomtexttabletypeids;
/*      */     
/*      */     private long endtimestamp;
/*      */     
/*      */     private int isouterturnconverttopoint;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  831 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  836 */       this.hitindexes = new HashSet();
/*  837 */       this.hitrandomtexttabletypeids = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.XiaoHuiKuaiPaoInfo _o1_)
/*      */     {
/*  842 */       if ((_o1_ instanceof XiaoHuiKuaiPaoInfo)) { assign((XiaoHuiKuaiPaoInfo)_o1_);
/*  843 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  844 */       } else if ((_o1_ instanceof XiaoHuiKuaiPaoInfo.Const)) assign(((XiaoHuiKuaiPaoInfo.Const)_o1_).nThis()); else {
/*  845 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(XiaoHuiKuaiPaoInfo _o_) {
/*  850 */       this.index = _o_.index;
/*  851 */       this.accumulateturncount = _o_.accumulateturncount;
/*  852 */       this.ticketcount = _o_.ticketcount;
/*  853 */       this.hitindexes = new HashSet();
/*  854 */       this.hitindexes.addAll(_o_.hitindexes);
/*  855 */       this.hitrandomtexttabletypeids = new HashSet();
/*  856 */       this.hitrandomtexttabletypeids.addAll(_o_.hitrandomtexttabletypeids);
/*  857 */       this.endtimestamp = _o_.endtimestamp;
/*  858 */       this.isouterturnconverttopoint = _o_.isouterturnconverttopoint;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  863 */       this.index = _o_.index;
/*  864 */       this.accumulateturncount = _o_.accumulateturncount;
/*  865 */       this.ticketcount = _o_.ticketcount;
/*  866 */       this.hitindexes = new HashSet();
/*  867 */       this.hitindexes.addAll(_o_.hitindexes);
/*  868 */       this.hitrandomtexttabletypeids = new HashSet();
/*  869 */       this.hitrandomtexttabletypeids.addAll(_o_.hitrandomtexttabletypeids);
/*  870 */       this.endtimestamp = _o_.endtimestamp;
/*  871 */       this.isouterturnconverttopoint = _o_.isouterturnconverttopoint;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  877 */       _os_.marshal(this.index);
/*  878 */       _os_.marshal(this.accumulateturncount);
/*  879 */       _os_.marshal(this.ticketcount);
/*  880 */       _os_.compact_uint32(this.hitindexes.size());
/*  881 */       for (Integer _v_ : this.hitindexes)
/*      */       {
/*  883 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  885 */       _os_.compact_uint32(this.hitrandomtexttabletypeids.size());
/*  886 */       for (Integer _v_ : this.hitrandomtexttabletypeids)
/*      */       {
/*  888 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  890 */       _os_.marshal(this.endtimestamp);
/*  891 */       _os_.marshal(this.isouterturnconverttopoint);
/*  892 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  898 */       this.index = _os_.unmarshal_int();
/*  899 */       this.accumulateturncount = _os_.unmarshal_int();
/*  900 */       this.ticketcount = _os_.unmarshal_int();
/*  901 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  903 */         int _v_ = 0;
/*  904 */         _v_ = _os_.unmarshal_int();
/*  905 */         this.hitindexes.add(Integer.valueOf(_v_));
/*      */       }
/*  907 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  909 */         int _v_ = 0;
/*  910 */         _v_ = _os_.unmarshal_int();
/*  911 */         this.hitrandomtexttabletypeids.add(Integer.valueOf(_v_));
/*      */       }
/*  913 */       this.endtimestamp = _os_.unmarshal_long();
/*  914 */       this.isouterturnconverttopoint = _os_.unmarshal_int();
/*  915 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  921 */       int _size_ = 0;
/*  922 */       _size_ += CodedOutputStream.computeInt32Size(1, this.index);
/*  923 */       _size_ += CodedOutputStream.computeInt32Size(2, this.accumulateturncount);
/*  924 */       _size_ += CodedOutputStream.computeInt32Size(3, this.ticketcount);
/*  925 */       for (Integer _v_ : this.hitindexes)
/*      */       {
/*  927 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */       }
/*  929 */       for (Integer _v_ : this.hitrandomtexttabletypeids)
/*      */       {
/*  931 */         _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */       }
/*  933 */       _size_ += CodedOutputStream.computeInt64Size(6, this.endtimestamp);
/*  934 */       _size_ += CodedOutputStream.computeInt32Size(7, this.isouterturnconverttopoint);
/*  935 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  943 */         _output_.writeInt32(1, this.index);
/*  944 */         _output_.writeInt32(2, this.accumulateturncount);
/*  945 */         _output_.writeInt32(3, this.ticketcount);
/*  946 */         for (Integer _v_ : this.hitindexes)
/*      */         {
/*  948 */           _output_.writeInt32(4, _v_.intValue());
/*      */         }
/*  950 */         for (Integer _v_ : this.hitrandomtexttabletypeids)
/*      */         {
/*  952 */           _output_.writeInt32(5, _v_.intValue());
/*      */         }
/*  954 */         _output_.writeInt64(6, this.endtimestamp);
/*  955 */         _output_.writeInt32(7, this.isouterturnconverttopoint);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  959 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  961 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  969 */         boolean done = false;
/*  970 */         while (!done)
/*      */         {
/*  972 */           int tag = _input_.readTag();
/*  973 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  977 */             done = true;
/*  978 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  982 */             this.index = _input_.readInt32();
/*  983 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  987 */             this.accumulateturncount = _input_.readInt32();
/*  988 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  992 */             this.ticketcount = _input_.readInt32();
/*  993 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  997 */             int _v_ = 0;
/*  998 */             _v_ = _input_.readInt32();
/*  999 */             this.hitindexes.add(Integer.valueOf(_v_));
/* 1000 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1004 */             int _v_ = 0;
/* 1005 */             _v_ = _input_.readInt32();
/* 1006 */             this.hitrandomtexttabletypeids.add(Integer.valueOf(_v_));
/* 1007 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1011 */             this.endtimestamp = _input_.readInt64();
/* 1012 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1016 */             this.isouterturnconverttopoint = _input_.readInt32();
/* 1017 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1021 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1023 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1032 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1036 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1038 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.XiaoHuiKuaiPaoInfo copy()
/*      */     {
/* 1044 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.XiaoHuiKuaiPaoInfo toData()
/*      */     {
/* 1050 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.XiaoHuiKuaiPaoInfo toBean()
/*      */     {
/* 1055 */       return new XiaoHuiKuaiPaoInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.XiaoHuiKuaiPaoInfo toDataIf()
/*      */     {
/* 1061 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.XiaoHuiKuaiPaoInfo toBeanIf()
/*      */     {
/* 1066 */       return new XiaoHuiKuaiPaoInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1072 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1076 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1080 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1084 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1088 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1092 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1096 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIndex()
/*      */     {
/* 1103 */       return this.index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAccumulateturncount()
/*      */     {
/* 1110 */       return this.accumulateturncount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTicketcount()
/*      */     {
/* 1117 */       return this.ticketcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getHitindexes()
/*      */     {
/* 1124 */       return this.hitindexes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getHitindexesAsData()
/*      */     {
/* 1131 */       return this.hitindexes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getHitrandomtexttabletypeids()
/*      */     {
/* 1138 */       return this.hitrandomtexttabletypeids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getHitrandomtexttabletypeidsAsData()
/*      */     {
/* 1145 */       return this.hitrandomtexttabletypeids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtimestamp()
/*      */     {
/* 1152 */       return this.endtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIsouterturnconverttopoint()
/*      */     {
/* 1159 */       return this.isouterturnconverttopoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIndex(int _v_)
/*      */     {
/* 1166 */       this.index = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAccumulateturncount(int _v_)
/*      */     {
/* 1173 */       this.accumulateturncount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTicketcount(int _v_)
/*      */     {
/* 1180 */       this.ticketcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtimestamp(long _v_)
/*      */     {
/* 1187 */       this.endtimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsouterturnconverttopoint(int _v_)
/*      */     {
/* 1194 */       this.isouterturnconverttopoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1200 */       if (!(_o1_ instanceof Data)) return false;
/* 1201 */       Data _o_ = (Data)_o1_;
/* 1202 */       if (this.index != _o_.index) return false;
/* 1203 */       if (this.accumulateturncount != _o_.accumulateturncount) return false;
/* 1204 */       if (this.ticketcount != _o_.ticketcount) return false;
/* 1205 */       if (!this.hitindexes.equals(_o_.hitindexes)) return false;
/* 1206 */       if (!this.hitrandomtexttabletypeids.equals(_o_.hitrandomtexttabletypeids)) return false;
/* 1207 */       if (this.endtimestamp != _o_.endtimestamp) return false;
/* 1208 */       if (this.isouterturnconverttopoint != _o_.isouterturnconverttopoint) return false;
/* 1209 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1215 */       int _h_ = 0;
/* 1216 */       _h_ += this.index;
/* 1217 */       _h_ += this.accumulateturncount;
/* 1218 */       _h_ += this.ticketcount;
/* 1219 */       _h_ += this.hitindexes.hashCode();
/* 1220 */       _h_ += this.hitrandomtexttabletypeids.hashCode();
/* 1221 */       _h_ = (int)(_h_ + this.endtimestamp);
/* 1222 */       _h_ += this.isouterturnconverttopoint;
/* 1223 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1229 */       StringBuilder _sb_ = new StringBuilder();
/* 1230 */       _sb_.append("(");
/* 1231 */       _sb_.append(this.index);
/* 1232 */       _sb_.append(",");
/* 1233 */       _sb_.append(this.accumulateturncount);
/* 1234 */       _sb_.append(",");
/* 1235 */       _sb_.append(this.ticketcount);
/* 1236 */       _sb_.append(",");
/* 1237 */       _sb_.append(this.hitindexes);
/* 1238 */       _sb_.append(",");
/* 1239 */       _sb_.append(this.hitrandomtexttabletypeids);
/* 1240 */       _sb_.append(",");
/* 1241 */       _sb_.append(this.endtimestamp);
/* 1242 */       _sb_.append(",");
/* 1243 */       _sb_.append(this.isouterturnconverttopoint);
/* 1244 */       _sb_.append(")");
/* 1245 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\XiaoHuiKuaiPaoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */