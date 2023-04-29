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
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class CrossCompeteAgainst extends XBean implements xbean.CrossCompeteAgainst
/*      */ {
/*      */   private xbean.CrossCompeteMatchFaction front_faction;
/*      */   private xbean.CrossCompeteMatchFaction behind_faction;
/*      */   private int compete_index;
/*      */   private int roam_serverid;
/*      */   private long winner;
/*      */   private long mercenary_faction;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.front_faction._reset_unsafe_();
/*   29 */     this.behind_faction._reset_unsafe_();
/*   30 */     this.compete_index = -1;
/*   31 */     this.roam_serverid = -1;
/*   32 */     this.winner = 0L;
/*   33 */     this.mercenary_faction = 0L;
/*      */   }
/*      */   
/*      */   CrossCompeteAgainst(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.front_faction = new CrossCompeteMatchFaction(0, this, "front_faction");
/*   40 */     this.behind_faction = new CrossCompeteMatchFaction(0, this, "behind_faction");
/*   41 */     this.compete_index = -1;
/*   42 */     this.roam_serverid = -1;
/*   43 */     this.winner = 0L;
/*   44 */     this.mercenary_faction = 0L;
/*      */   }
/*      */   
/*      */   public CrossCompeteAgainst()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CrossCompeteAgainst(CrossCompeteAgainst _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CrossCompeteAgainst(xbean.CrossCompeteAgainst _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof CrossCompeteAgainst)) { assign((CrossCompeteAgainst)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CrossCompeteAgainst _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.front_faction = new CrossCompeteMatchFaction(_o_.front_faction, this, "front_faction");
/*   70 */     this.behind_faction = new CrossCompeteMatchFaction(_o_.behind_faction, this, "behind_faction");
/*   71 */     this.compete_index = _o_.compete_index;
/*   72 */     this.roam_serverid = _o_.roam_serverid;
/*   73 */     this.winner = _o_.winner;
/*   74 */     this.mercenary_faction = _o_.mercenary_faction;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   79 */     this.front_faction = new CrossCompeteMatchFaction(_o_.front_faction, this, "front_faction");
/*   80 */     this.behind_faction = new CrossCompeteMatchFaction(_o_.behind_faction, this, "behind_faction");
/*   81 */     this.compete_index = _o_.compete_index;
/*   82 */     this.roam_serverid = _o_.roam_serverid;
/*   83 */     this.winner = _o_.winner;
/*   84 */     this.mercenary_faction = _o_.mercenary_faction;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     this.front_faction.marshal(_os_);
/*   92 */     this.behind_faction.marshal(_os_);
/*   93 */     _os_.marshal(this.compete_index);
/*   94 */     _os_.marshal(this.roam_serverid);
/*   95 */     _os_.marshal(this.winner);
/*   96 */     _os_.marshal(this.mercenary_faction);
/*   97 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     this.front_faction.unmarshal(_os_);
/*  105 */     this.behind_faction.unmarshal(_os_);
/*  106 */     this.compete_index = _os_.unmarshal_int();
/*  107 */     this.roam_serverid = _os_.unmarshal_int();
/*  108 */     this.winner = _os_.unmarshal_long();
/*  109 */     this.mercenary_faction = _os_.unmarshal_long();
/*  110 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*  117 */     int _size_ = 0;
/*  118 */     _size_ += CodedOutputStream.computeMessageSize(1, this.front_faction);
/*  119 */     _size_ += CodedOutputStream.computeMessageSize(2, this.behind_faction);
/*  120 */     _size_ += CodedOutputStream.computeInt32Size(3, this.compete_index);
/*  121 */     _size_ += CodedOutputStream.computeInt32Size(4, this.roam_serverid);
/*  122 */     _size_ += CodedOutputStream.computeInt64Size(5, this.winner);
/*  123 */     _size_ += CodedOutputStream.computeInt64Size(6, this.mercenary_faction);
/*  124 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  130 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  133 */       _output_.writeMessage(1, this.front_faction);
/*  134 */       _output_.writeMessage(2, this.behind_faction);
/*  135 */       _output_.writeInt32(3, this.compete_index);
/*  136 */       _output_.writeInt32(4, this.roam_serverid);
/*  137 */       _output_.writeInt64(5, this.winner);
/*  138 */       _output_.writeInt64(6, this.mercenary_faction);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  142 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  144 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  150 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  153 */       boolean done = false;
/*  154 */       while (!done)
/*      */       {
/*  156 */         int tag = _input_.readTag();
/*  157 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  161 */           done = true;
/*  162 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  166 */           _input_.readMessage(this.front_faction);
/*  167 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  171 */           _input_.readMessage(this.behind_faction);
/*  172 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  176 */           this.compete_index = _input_.readInt32();
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  181 */           this.roam_serverid = _input_.readInt32();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  186 */           this.winner = _input_.readInt64();
/*  187 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  191 */           this.mercenary_faction = _input_.readInt64();
/*  192 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  196 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  198 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  207 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  211 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  213 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossCompeteAgainst copy()
/*      */   {
/*  219 */     _xdb_verify_unsafe_();
/*  220 */     return new CrossCompeteAgainst(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossCompeteAgainst toData()
/*      */   {
/*  226 */     _xdb_verify_unsafe_();
/*  227 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossCompeteAgainst toBean()
/*      */   {
/*  232 */     _xdb_verify_unsafe_();
/*  233 */     return new CrossCompeteAgainst(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossCompeteAgainst toDataIf()
/*      */   {
/*  239 */     _xdb_verify_unsafe_();
/*  240 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossCompeteAgainst toBeanIf()
/*      */   {
/*  245 */     _xdb_verify_unsafe_();
/*  246 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  252 */     _xdb_verify_unsafe_();
/*  253 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.CrossCompeteMatchFaction getFront_faction()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return this.front_faction;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.CrossCompeteMatchFaction getBehind_faction()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return this.behind_faction;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCompete_index()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return this.compete_index;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRoam_serverid()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return this.roam_serverid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWinner()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return this.winner;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMercenary_faction()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this.mercenary_faction;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCompete_index(int _v_)
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     xdb.Logs.logIf(new LogKey(this, "compete_index")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  313 */         new LogInt(this, CrossCompeteAgainst.this.compete_index)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  317 */             CrossCompeteAgainst.this.compete_index = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  321 */     });
/*  322 */     this.compete_index = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoam_serverid(int _v_)
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     xdb.Logs.logIf(new LogKey(this, "roam_serverid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  334 */         new LogInt(this, CrossCompeteAgainst.this.roam_serverid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  338 */             CrossCompeteAgainst.this.roam_serverid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  342 */     });
/*  343 */     this.roam_serverid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWinner(long _v_)
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     xdb.Logs.logIf(new LogKey(this, "winner")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  355 */         new LogLong(this, CrossCompeteAgainst.this.winner)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  359 */             CrossCompeteAgainst.this.winner = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  363 */     });
/*  364 */     this.winner = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMercenary_faction(long _v_)
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     xdb.Logs.logIf(new LogKey(this, "mercenary_faction")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  376 */         new LogLong(this, CrossCompeteAgainst.this.mercenary_faction)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  380 */             CrossCompeteAgainst.this.mercenary_faction = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  384 */     });
/*  385 */     this.mercenary_faction = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*  392 */     CrossCompeteAgainst _o_ = null;
/*  393 */     if ((_o1_ instanceof CrossCompeteAgainst)) { _o_ = (CrossCompeteAgainst)_o1_;
/*  394 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  395 */       return false;
/*  396 */     if (!this.front_faction.equals(_o_.front_faction)) return false;
/*  397 */     if (!this.behind_faction.equals(_o_.behind_faction)) return false;
/*  398 */     if (this.compete_index != _o_.compete_index) return false;
/*  399 */     if (this.roam_serverid != _o_.roam_serverid) return false;
/*  400 */     if (this.winner != _o_.winner) return false;
/*  401 */     if (this.mercenary_faction != _o_.mercenary_faction) return false;
/*  402 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     int _h_ = 0;
/*  410 */     _h_ += this.front_faction.hashCode();
/*  411 */     _h_ += this.behind_faction.hashCode();
/*  412 */     _h_ += this.compete_index;
/*  413 */     _h_ += this.roam_serverid;
/*  414 */     _h_ = (int)(_h_ + this.winner);
/*  415 */     _h_ = (int)(_h_ + this.mercenary_faction);
/*  416 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     StringBuilder _sb_ = new StringBuilder();
/*  424 */     _sb_.append("(");
/*  425 */     _sb_.append(this.front_faction);
/*  426 */     _sb_.append(",");
/*  427 */     _sb_.append(this.behind_faction);
/*  428 */     _sb_.append(",");
/*  429 */     _sb_.append(this.compete_index);
/*  430 */     _sb_.append(",");
/*  431 */     _sb_.append(this.roam_serverid);
/*  432 */     _sb_.append(",");
/*  433 */     _sb_.append(this.winner);
/*  434 */     _sb_.append(",");
/*  435 */     _sb_.append(this.mercenary_faction);
/*  436 */     _sb_.append(")");
/*  437 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  443 */     ListenableBean lb = new ListenableBean();
/*  444 */     lb.add(new ListenableChanged().setVarName("front_faction"));
/*  445 */     lb.add(new ListenableChanged().setVarName("behind_faction"));
/*  446 */     lb.add(new ListenableChanged().setVarName("compete_index"));
/*  447 */     lb.add(new ListenableChanged().setVarName("roam_serverid"));
/*  448 */     lb.add(new ListenableChanged().setVarName("winner"));
/*  449 */     lb.add(new ListenableChanged().setVarName("mercenary_faction"));
/*  450 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CrossCompeteAgainst {
/*      */     private Const() {}
/*      */     
/*      */     CrossCompeteAgainst nThis() {
/*  457 */       return CrossCompeteAgainst.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  463 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteAgainst copy()
/*      */     {
/*  469 */       return CrossCompeteAgainst.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteAgainst toData()
/*      */     {
/*  475 */       return CrossCompeteAgainst.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CrossCompeteAgainst toBean()
/*      */     {
/*  480 */       return CrossCompeteAgainst.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteAgainst toDataIf()
/*      */     {
/*  486 */       return CrossCompeteAgainst.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CrossCompeteAgainst toBeanIf()
/*      */     {
/*  491 */       return CrossCompeteAgainst.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.CrossCompeteMatchFaction getFront_faction()
/*      */     {
/*  498 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  499 */       return (xbean.CrossCompeteMatchFaction)xdb.Consts.toConst(CrossCompeteAgainst.this.front_faction);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.CrossCompeteMatchFaction getBehind_faction()
/*      */     {
/*  506 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  507 */       return (xbean.CrossCompeteMatchFaction)xdb.Consts.toConst(CrossCompeteAgainst.this.behind_faction);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCompete_index()
/*      */     {
/*  514 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  515 */       return CrossCompeteAgainst.this.compete_index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRoam_serverid()
/*      */     {
/*  522 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  523 */       return CrossCompeteAgainst.this.roam_serverid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWinner()
/*      */     {
/*  530 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  531 */       return CrossCompeteAgainst.this.winner;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMercenary_faction()
/*      */     {
/*  538 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  539 */       return CrossCompeteAgainst.this.mercenary_faction;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCompete_index(int _v_)
/*      */     {
/*  546 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  547 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoam_serverid(int _v_)
/*      */     {
/*  554 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  555 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWinner(long _v_)
/*      */     {
/*  562 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  563 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMercenary_faction(long _v_)
/*      */     {
/*  570 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  571 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  577 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  578 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  584 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  585 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  591 */       return CrossCompeteAgainst.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  597 */       return CrossCompeteAgainst.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  603 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  604 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  610 */       return CrossCompeteAgainst.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  616 */       return CrossCompeteAgainst.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  622 */       CrossCompeteAgainst.this._xdb_verify_unsafe_();
/*  623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  629 */       return CrossCompeteAgainst.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  635 */       return CrossCompeteAgainst.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  641 */       return CrossCompeteAgainst.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  647 */       return CrossCompeteAgainst.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  653 */       return CrossCompeteAgainst.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  659 */       return CrossCompeteAgainst.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  665 */       return CrossCompeteAgainst.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CrossCompeteAgainst
/*      */   {
/*      */     private xbean.CrossCompeteMatchFaction front_faction;
/*      */     
/*      */     private xbean.CrossCompeteMatchFaction behind_faction;
/*      */     
/*      */     private int compete_index;
/*      */     
/*      */     private int roam_serverid;
/*      */     
/*      */     private long winner;
/*      */     
/*      */     private long mercenary_faction;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  687 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  692 */       this.front_faction = new CrossCompeteMatchFaction.Data();
/*  693 */       this.behind_faction = new CrossCompeteMatchFaction.Data();
/*  694 */       this.compete_index = -1;
/*  695 */       this.roam_serverid = -1;
/*  696 */       this.winner = 0L;
/*  697 */       this.mercenary_faction = 0L;
/*      */     }
/*      */     
/*      */     Data(xbean.CrossCompeteAgainst _o1_)
/*      */     {
/*  702 */       if ((_o1_ instanceof CrossCompeteAgainst)) { assign((CrossCompeteAgainst)_o1_);
/*  703 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  704 */       } else if ((_o1_ instanceof CrossCompeteAgainst.Const)) assign(((CrossCompeteAgainst.Const)_o1_).nThis()); else {
/*  705 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CrossCompeteAgainst _o_) {
/*  710 */       this.front_faction = new CrossCompeteMatchFaction.Data(_o_.front_faction);
/*  711 */       this.behind_faction = new CrossCompeteMatchFaction.Data(_o_.behind_faction);
/*  712 */       this.compete_index = _o_.compete_index;
/*  713 */       this.roam_serverid = _o_.roam_serverid;
/*  714 */       this.winner = _o_.winner;
/*  715 */       this.mercenary_faction = _o_.mercenary_faction;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  720 */       this.front_faction = new CrossCompeteMatchFaction.Data(_o_.front_faction);
/*  721 */       this.behind_faction = new CrossCompeteMatchFaction.Data(_o_.behind_faction);
/*  722 */       this.compete_index = _o_.compete_index;
/*  723 */       this.roam_serverid = _o_.roam_serverid;
/*  724 */       this.winner = _o_.winner;
/*  725 */       this.mercenary_faction = _o_.mercenary_faction;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  731 */       this.front_faction.marshal(_os_);
/*  732 */       this.behind_faction.marshal(_os_);
/*  733 */       _os_.marshal(this.compete_index);
/*  734 */       _os_.marshal(this.roam_serverid);
/*  735 */       _os_.marshal(this.winner);
/*  736 */       _os_.marshal(this.mercenary_faction);
/*  737 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  743 */       this.front_faction.unmarshal(_os_);
/*  744 */       this.behind_faction.unmarshal(_os_);
/*  745 */       this.compete_index = _os_.unmarshal_int();
/*  746 */       this.roam_serverid = _os_.unmarshal_int();
/*  747 */       this.winner = _os_.unmarshal_long();
/*  748 */       this.mercenary_faction = _os_.unmarshal_long();
/*  749 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  755 */       int _size_ = 0;
/*  756 */       _size_ += CodedOutputStream.computeMessageSize(1, this.front_faction);
/*  757 */       _size_ += CodedOutputStream.computeMessageSize(2, this.behind_faction);
/*  758 */       _size_ += CodedOutputStream.computeInt32Size(3, this.compete_index);
/*  759 */       _size_ += CodedOutputStream.computeInt32Size(4, this.roam_serverid);
/*  760 */       _size_ += CodedOutputStream.computeInt64Size(5, this.winner);
/*  761 */       _size_ += CodedOutputStream.computeInt64Size(6, this.mercenary_faction);
/*  762 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  770 */         _output_.writeMessage(1, this.front_faction);
/*  771 */         _output_.writeMessage(2, this.behind_faction);
/*  772 */         _output_.writeInt32(3, this.compete_index);
/*  773 */         _output_.writeInt32(4, this.roam_serverid);
/*  774 */         _output_.writeInt64(5, this.winner);
/*  775 */         _output_.writeInt64(6, this.mercenary_faction);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  779 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  781 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  789 */         boolean done = false;
/*  790 */         while (!done)
/*      */         {
/*  792 */           int tag = _input_.readTag();
/*  793 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  797 */             done = true;
/*  798 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/*  802 */             _input_.readMessage(this.front_faction);
/*  803 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/*  807 */             _input_.readMessage(this.behind_faction);
/*  808 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  812 */             this.compete_index = _input_.readInt32();
/*  813 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  817 */             this.roam_serverid = _input_.readInt32();
/*  818 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  822 */             this.winner = _input_.readInt64();
/*  823 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  827 */             this.mercenary_faction = _input_.readInt64();
/*  828 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  832 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  834 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  843 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  847 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  849 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteAgainst copy()
/*      */     {
/*  855 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteAgainst toData()
/*      */     {
/*  861 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CrossCompeteAgainst toBean()
/*      */     {
/*  866 */       return new CrossCompeteAgainst(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteAgainst toDataIf()
/*      */     {
/*  872 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CrossCompeteAgainst toBeanIf()
/*      */     {
/*  877 */       return new CrossCompeteAgainst(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  883 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  887 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  891 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  895 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  899 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  903 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  907 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.CrossCompeteMatchFaction getFront_faction()
/*      */     {
/*  914 */       return this.front_faction;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.CrossCompeteMatchFaction getBehind_faction()
/*      */     {
/*  921 */       return this.behind_faction;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCompete_index()
/*      */     {
/*  928 */       return this.compete_index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRoam_serverid()
/*      */     {
/*  935 */       return this.roam_serverid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWinner()
/*      */     {
/*  942 */       return this.winner;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMercenary_faction()
/*      */     {
/*  949 */       return this.mercenary_faction;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCompete_index(int _v_)
/*      */     {
/*  956 */       this.compete_index = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoam_serverid(int _v_)
/*      */     {
/*  963 */       this.roam_serverid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWinner(long _v_)
/*      */     {
/*  970 */       this.winner = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMercenary_faction(long _v_)
/*      */     {
/*  977 */       this.mercenary_faction = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  983 */       if (!(_o1_ instanceof Data)) return false;
/*  984 */       Data _o_ = (Data)_o1_;
/*  985 */       if (!this.front_faction.equals(_o_.front_faction)) return false;
/*  986 */       if (!this.behind_faction.equals(_o_.behind_faction)) return false;
/*  987 */       if (this.compete_index != _o_.compete_index) return false;
/*  988 */       if (this.roam_serverid != _o_.roam_serverid) return false;
/*  989 */       if (this.winner != _o_.winner) return false;
/*  990 */       if (this.mercenary_faction != _o_.mercenary_faction) return false;
/*  991 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/*  997 */       int _h_ = 0;
/*  998 */       _h_ += this.front_faction.hashCode();
/*  999 */       _h_ += this.behind_faction.hashCode();
/* 1000 */       _h_ += this.compete_index;
/* 1001 */       _h_ += this.roam_serverid;
/* 1002 */       _h_ = (int)(_h_ + this.winner);
/* 1003 */       _h_ = (int)(_h_ + this.mercenary_faction);
/* 1004 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1010 */       StringBuilder _sb_ = new StringBuilder();
/* 1011 */       _sb_.append("(");
/* 1012 */       _sb_.append(this.front_faction);
/* 1013 */       _sb_.append(",");
/* 1014 */       _sb_.append(this.behind_faction);
/* 1015 */       _sb_.append(",");
/* 1016 */       _sb_.append(this.compete_index);
/* 1017 */       _sb_.append(",");
/* 1018 */       _sb_.append(this.roam_serverid);
/* 1019 */       _sb_.append(",");
/* 1020 */       _sb_.append(this.winner);
/* 1021 */       _sb_.append(",");
/* 1022 */       _sb_.append(this.mercenary_faction);
/* 1023 */       _sb_.append(")");
/* 1024 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossCompeteAgainst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */