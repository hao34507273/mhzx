/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import ppbio.ByteString;
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
/*      */ 
/*      */ public final class CrossCompeteMatchFaction extends XBean implements xbean.CrossCompeteMatchFaction
/*      */ {
/*      */   private String name;
/*      */   private int level;
/*      */   private int server_level;
/*      */   private int member_count;
/*      */   private int win_times;
/*      */   private int lose_times;
/*      */   private int active_member_count;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.name = "";
/*   31 */     this.level = 0;
/*   32 */     this.server_level = 0;
/*   33 */     this.member_count = 0;
/*   34 */     this.win_times = 0;
/*   35 */     this.lose_times = 0;
/*   36 */     this.active_member_count = 0;
/*      */   }
/*      */   
/*      */   CrossCompeteMatchFaction(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.name = "";
/*      */   }
/*      */   
/*      */   public CrossCompeteMatchFaction()
/*      */   {
/*   47 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CrossCompeteMatchFaction(CrossCompeteMatchFaction _o_)
/*      */   {
/*   52 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CrossCompeteMatchFaction(xbean.CrossCompeteMatchFaction _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   57 */     super(_xp_, _vn_);
/*   58 */     if ((_o1_ instanceof CrossCompeteMatchFaction)) { assign((CrossCompeteMatchFaction)_o1_);
/*   59 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   60 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   61 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CrossCompeteMatchFaction _o_) {
/*   66 */     _o_._xdb_verify_unsafe_();
/*   67 */     this.name = _o_.name;
/*   68 */     this.level = _o_.level;
/*   69 */     this.server_level = _o_.server_level;
/*   70 */     this.member_count = _o_.member_count;
/*   71 */     this.win_times = _o_.win_times;
/*   72 */     this.lose_times = _o_.lose_times;
/*   73 */     this.active_member_count = _o_.active_member_count;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   78 */     this.name = _o_.name;
/*   79 */     this.level = _o_.level;
/*   80 */     this.server_level = _o_.server_level;
/*   81 */     this.member_count = _o_.member_count;
/*   82 */     this.win_times = _o_.win_times;
/*   83 */     this.lose_times = _o_.lose_times;
/*   84 */     this.active_member_count = _o_.active_member_count;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.marshal(this.name, "UTF-16LE");
/*   92 */     _os_.marshal(this.level);
/*   93 */     _os_.marshal(this.server_level);
/*   94 */     _os_.marshal(this.member_count);
/*   95 */     _os_.marshal(this.win_times);
/*   96 */     _os_.marshal(this.lose_times);
/*   97 */     _os_.marshal(this.active_member_count);
/*   98 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  104 */     _xdb_verify_unsafe_();
/*  105 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  106 */     this.level = _os_.unmarshal_int();
/*  107 */     this.server_level = _os_.unmarshal_int();
/*  108 */     this.member_count = _os_.unmarshal_int();
/*  109 */     this.win_times = _os_.unmarshal_int();
/*  110 */     this.lose_times = _os_.unmarshal_int();
/*  111 */     this.active_member_count = _os_.unmarshal_int();
/*  112 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  118 */     _xdb_verify_unsafe_();
/*  119 */     int _size_ = 0;
/*      */     try
/*      */     {
/*  122 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  126 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  128 */     _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/*  129 */     _size_ += CodedOutputStream.computeInt32Size(3, this.server_level);
/*  130 */     _size_ += CodedOutputStream.computeInt32Size(4, this.member_count);
/*  131 */     _size_ += CodedOutputStream.computeInt32Size(5, this.win_times);
/*  132 */     _size_ += CodedOutputStream.computeInt32Size(6, this.lose_times);
/*  133 */     _size_ += CodedOutputStream.computeInt32Size(7, this.active_member_count);
/*  134 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  143 */       _output_.writeBytes(1, ByteString.copyFrom(this.name, "UTF-16LE"));
/*  144 */       _output_.writeInt32(2, this.level);
/*  145 */       _output_.writeInt32(3, this.server_level);
/*  146 */       _output_.writeInt32(4, this.member_count);
/*  147 */       _output_.writeInt32(5, this.win_times);
/*  148 */       _output_.writeInt32(6, this.lose_times);
/*  149 */       _output_.writeInt32(7, this.active_member_count);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  153 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  155 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  161 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  164 */       boolean done = false;
/*  165 */       while (!done)
/*      */       {
/*  167 */         int tag = _input_.readTag();
/*  168 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  172 */           done = true;
/*  173 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  177 */           this.name = _input_.readBytes().toString("UTF-16LE");
/*  178 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  182 */           this.level = _input_.readInt32();
/*  183 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  187 */           this.server_level = _input_.readInt32();
/*  188 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  192 */           this.member_count = _input_.readInt32();
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  197 */           this.win_times = _input_.readInt32();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  202 */           this.lose_times = _input_.readInt32();
/*  203 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  207 */           this.active_member_count = _input_.readInt32();
/*  208 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  212 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  214 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  223 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  227 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  229 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossCompeteMatchFaction copy()
/*      */   {
/*  235 */     _xdb_verify_unsafe_();
/*  236 */     return new CrossCompeteMatchFaction(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossCompeteMatchFaction toData()
/*      */   {
/*  242 */     _xdb_verify_unsafe_();
/*  243 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossCompeteMatchFaction toBean()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return new CrossCompeteMatchFaction(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossCompeteMatchFaction toDataIf()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossCompeteMatchFaction toBeanIf()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return this.name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNameOctets()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return Octets.wrap(getName(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevel()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return this.level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getServer_level()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this.server_level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMember_count()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return this.member_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWin_times()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return this.win_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLose_times()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return this.lose_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActive_member_count()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return this.active_member_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName(String _v_)
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     if (null == _v_)
/*  342 */       throw new NullPointerException();
/*  343 */     Logs.logIf(new LogKey(this, "name")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  347 */         new xdb.logs.LogString(this, CrossCompeteMatchFaction.this.name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  351 */             CrossCompeteMatchFaction.this.name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  355 */     });
/*  356 */     this.name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNameOctets(Octets _v_)
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     setName(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevel(int _v_)
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     Logs.logIf(new LogKey(this, "level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  376 */         new LogInt(this, CrossCompeteMatchFaction.this.level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  380 */             CrossCompeteMatchFaction.this.level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  384 */     });
/*  385 */     this.level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setServer_level(int _v_)
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*  393 */     Logs.logIf(new LogKey(this, "server_level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  397 */         new LogInt(this, CrossCompeteMatchFaction.this.server_level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  401 */             CrossCompeteMatchFaction.this.server_level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  405 */     });
/*  406 */     this.server_level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMember_count(int _v_)
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*  414 */     Logs.logIf(new LogKey(this, "member_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  418 */         new LogInt(this, CrossCompeteMatchFaction.this.member_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  422 */             CrossCompeteMatchFaction.this.member_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  426 */     });
/*  427 */     this.member_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWin_times(int _v_)
/*      */   {
/*  434 */     _xdb_verify_unsafe_();
/*  435 */     Logs.logIf(new LogKey(this, "win_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  439 */         new LogInt(this, CrossCompeteMatchFaction.this.win_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  443 */             CrossCompeteMatchFaction.this.win_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  447 */     });
/*  448 */     this.win_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLose_times(int _v_)
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*  456 */     Logs.logIf(new LogKey(this, "lose_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  460 */         new LogInt(this, CrossCompeteMatchFaction.this.lose_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  464 */             CrossCompeteMatchFaction.this.lose_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  468 */     });
/*  469 */     this.lose_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActive_member_count(int _v_)
/*      */   {
/*  476 */     _xdb_verify_unsafe_();
/*  477 */     Logs.logIf(new LogKey(this, "active_member_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  481 */         new LogInt(this, CrossCompeteMatchFaction.this.active_member_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  485 */             CrossCompeteMatchFaction.this.active_member_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  489 */     });
/*  490 */     this.active_member_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  496 */     _xdb_verify_unsafe_();
/*  497 */     CrossCompeteMatchFaction _o_ = null;
/*  498 */     if ((_o1_ instanceof CrossCompeteMatchFaction)) { _o_ = (CrossCompeteMatchFaction)_o1_;
/*  499 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  500 */       return false;
/*  501 */     if (!this.name.equals(_o_.name)) return false;
/*  502 */     if (this.level != _o_.level) return false;
/*  503 */     if (this.server_level != _o_.server_level) return false;
/*  504 */     if (this.member_count != _o_.member_count) return false;
/*  505 */     if (this.win_times != _o_.win_times) return false;
/*  506 */     if (this.lose_times != _o_.lose_times) return false;
/*  507 */     if (this.active_member_count != _o_.active_member_count) return false;
/*  508 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  514 */     _xdb_verify_unsafe_();
/*  515 */     int _h_ = 0;
/*  516 */     _h_ += this.name.hashCode();
/*  517 */     _h_ += this.level;
/*  518 */     _h_ += this.server_level;
/*  519 */     _h_ += this.member_count;
/*  520 */     _h_ += this.win_times;
/*  521 */     _h_ += this.lose_times;
/*  522 */     _h_ += this.active_member_count;
/*  523 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  529 */     _xdb_verify_unsafe_();
/*  530 */     StringBuilder _sb_ = new StringBuilder();
/*  531 */     _sb_.append("(");
/*  532 */     _sb_.append("'").append(this.name).append("'");
/*  533 */     _sb_.append(",");
/*  534 */     _sb_.append(this.level);
/*  535 */     _sb_.append(",");
/*  536 */     _sb_.append(this.server_level);
/*  537 */     _sb_.append(",");
/*  538 */     _sb_.append(this.member_count);
/*  539 */     _sb_.append(",");
/*  540 */     _sb_.append(this.win_times);
/*  541 */     _sb_.append(",");
/*  542 */     _sb_.append(this.lose_times);
/*  543 */     _sb_.append(",");
/*  544 */     _sb_.append(this.active_member_count);
/*  545 */     _sb_.append(")");
/*  546 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  552 */     ListenableBean lb = new ListenableBean();
/*  553 */     lb.add(new ListenableChanged().setVarName("name"));
/*  554 */     lb.add(new ListenableChanged().setVarName("level"));
/*  555 */     lb.add(new ListenableChanged().setVarName("server_level"));
/*  556 */     lb.add(new ListenableChanged().setVarName("member_count"));
/*  557 */     lb.add(new ListenableChanged().setVarName("win_times"));
/*  558 */     lb.add(new ListenableChanged().setVarName("lose_times"));
/*  559 */     lb.add(new ListenableChanged().setVarName("active_member_count"));
/*  560 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CrossCompeteMatchFaction {
/*      */     private Const() {}
/*      */     
/*      */     CrossCompeteMatchFaction nThis() {
/*  567 */       return CrossCompeteMatchFaction.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  573 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteMatchFaction copy()
/*      */     {
/*  579 */       return CrossCompeteMatchFaction.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteMatchFaction toData()
/*      */     {
/*  585 */       return CrossCompeteMatchFaction.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CrossCompeteMatchFaction toBean()
/*      */     {
/*  590 */       return CrossCompeteMatchFaction.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteMatchFaction toDataIf()
/*      */     {
/*  596 */       return CrossCompeteMatchFaction.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CrossCompeteMatchFaction toBeanIf()
/*      */     {
/*  601 */       return CrossCompeteMatchFaction.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/*  608 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  609 */       return CrossCompeteMatchFaction.this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/*  616 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  617 */       return CrossCompeteMatchFaction.this.getNameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/*  624 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  625 */       return CrossCompeteMatchFaction.this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getServer_level()
/*      */     {
/*  632 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  633 */       return CrossCompeteMatchFaction.this.server_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMember_count()
/*      */     {
/*  640 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  641 */       return CrossCompeteMatchFaction.this.member_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/*  648 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  649 */       return CrossCompeteMatchFaction.this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_times()
/*      */     {
/*  656 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  657 */       return CrossCompeteMatchFaction.this.lose_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActive_member_count()
/*      */     {
/*  664 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  665 */       return CrossCompeteMatchFaction.this.active_member_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/*  672 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  673 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/*  680 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  681 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/*  688 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  689 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setServer_level(int _v_)
/*      */     {
/*  696 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  697 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMember_count(int _v_)
/*      */     {
/*  704 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  705 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/*  712 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  713 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_times(int _v_)
/*      */     {
/*  720 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  721 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_member_count(int _v_)
/*      */     {
/*  728 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  729 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  735 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  736 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  742 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  743 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  749 */       return CrossCompeteMatchFaction.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  755 */       return CrossCompeteMatchFaction.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  761 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  762 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  768 */       return CrossCompeteMatchFaction.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  774 */       return CrossCompeteMatchFaction.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  780 */       CrossCompeteMatchFaction.this._xdb_verify_unsafe_();
/*  781 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  787 */       return CrossCompeteMatchFaction.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  793 */       return CrossCompeteMatchFaction.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  799 */       return CrossCompeteMatchFaction.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  805 */       return CrossCompeteMatchFaction.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  811 */       return CrossCompeteMatchFaction.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  817 */       return CrossCompeteMatchFaction.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  823 */       return CrossCompeteMatchFaction.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CrossCompeteMatchFaction
/*      */   {
/*      */     private String name;
/*      */     
/*      */     private int level;
/*      */     
/*      */     private int server_level;
/*      */     
/*      */     private int member_count;
/*      */     
/*      */     private int win_times;
/*      */     
/*      */     private int lose_times;
/*      */     
/*      */     private int active_member_count;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  847 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  852 */       this.name = "";
/*      */     }
/*      */     
/*      */     Data(xbean.CrossCompeteMatchFaction _o1_)
/*      */     {
/*  857 */       if ((_o1_ instanceof CrossCompeteMatchFaction)) { assign((CrossCompeteMatchFaction)_o1_);
/*  858 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  859 */       } else if ((_o1_ instanceof CrossCompeteMatchFaction.Const)) assign(((CrossCompeteMatchFaction.Const)_o1_).nThis()); else {
/*  860 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CrossCompeteMatchFaction _o_) {
/*  865 */       this.name = _o_.name;
/*  866 */       this.level = _o_.level;
/*  867 */       this.server_level = _o_.server_level;
/*  868 */       this.member_count = _o_.member_count;
/*  869 */       this.win_times = _o_.win_times;
/*  870 */       this.lose_times = _o_.lose_times;
/*  871 */       this.active_member_count = _o_.active_member_count;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  876 */       this.name = _o_.name;
/*  877 */       this.level = _o_.level;
/*  878 */       this.server_level = _o_.server_level;
/*  879 */       this.member_count = _o_.member_count;
/*  880 */       this.win_times = _o_.win_times;
/*  881 */       this.lose_times = _o_.lose_times;
/*  882 */       this.active_member_count = _o_.active_member_count;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  888 */       _os_.marshal(this.name, "UTF-16LE");
/*  889 */       _os_.marshal(this.level);
/*  890 */       _os_.marshal(this.server_level);
/*  891 */       _os_.marshal(this.member_count);
/*  892 */       _os_.marshal(this.win_times);
/*  893 */       _os_.marshal(this.lose_times);
/*  894 */       _os_.marshal(this.active_member_count);
/*  895 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  901 */       this.name = _os_.unmarshal_String("UTF-16LE");
/*  902 */       this.level = _os_.unmarshal_int();
/*  903 */       this.server_level = _os_.unmarshal_int();
/*  904 */       this.member_count = _os_.unmarshal_int();
/*  905 */       this.win_times = _os_.unmarshal_int();
/*  906 */       this.lose_times = _os_.unmarshal_int();
/*  907 */       this.active_member_count = _os_.unmarshal_int();
/*  908 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  914 */       int _size_ = 0;
/*      */       try
/*      */       {
/*  917 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  921 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  923 */       _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/*  924 */       _size_ += CodedOutputStream.computeInt32Size(3, this.server_level);
/*  925 */       _size_ += CodedOutputStream.computeInt32Size(4, this.member_count);
/*  926 */       _size_ += CodedOutputStream.computeInt32Size(5, this.win_times);
/*  927 */       _size_ += CodedOutputStream.computeInt32Size(6, this.lose_times);
/*  928 */       _size_ += CodedOutputStream.computeInt32Size(7, this.active_member_count);
/*  929 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  937 */         _output_.writeBytes(1, ByteString.copyFrom(this.name, "UTF-16LE"));
/*  938 */         _output_.writeInt32(2, this.level);
/*  939 */         _output_.writeInt32(3, this.server_level);
/*  940 */         _output_.writeInt32(4, this.member_count);
/*  941 */         _output_.writeInt32(5, this.win_times);
/*  942 */         _output_.writeInt32(6, this.lose_times);
/*  943 */         _output_.writeInt32(7, this.active_member_count);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  947 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  949 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  957 */         boolean done = false;
/*  958 */         while (!done)
/*      */         {
/*  960 */           int tag = _input_.readTag();
/*  961 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  965 */             done = true;
/*  966 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/*  970 */             this.name = _input_.readBytes().toString("UTF-16LE");
/*  971 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  975 */             this.level = _input_.readInt32();
/*  976 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  980 */             this.server_level = _input_.readInt32();
/*  981 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  985 */             this.member_count = _input_.readInt32();
/*  986 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  990 */             this.win_times = _input_.readInt32();
/*  991 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  995 */             this.lose_times = _input_.readInt32();
/*  996 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1000 */             this.active_member_count = _input_.readInt32();
/* 1001 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1005 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1007 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1016 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1020 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1022 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteMatchFaction copy()
/*      */     {
/* 1028 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteMatchFaction toData()
/*      */     {
/* 1034 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CrossCompeteMatchFaction toBean()
/*      */     {
/* 1039 */       return new CrossCompeteMatchFaction(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompeteMatchFaction toDataIf()
/*      */     {
/* 1045 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CrossCompeteMatchFaction toBeanIf()
/*      */     {
/* 1050 */       return new CrossCompeteMatchFaction(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1056 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1060 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1064 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1068 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1072 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1076 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1080 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/* 1087 */       return this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/* 1094 */       return Octets.wrap(getName(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/* 1101 */       return this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getServer_level()
/*      */     {
/* 1108 */       return this.server_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMember_count()
/*      */     {
/* 1115 */       return this.member_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/* 1122 */       return this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_times()
/*      */     {
/* 1129 */       return this.lose_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActive_member_count()
/*      */     {
/* 1136 */       return this.active_member_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/* 1143 */       if (null == _v_)
/* 1144 */         throw new NullPointerException();
/* 1145 */       this.name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/* 1152 */       setName(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 1159 */       this.level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setServer_level(int _v_)
/*      */     {
/* 1166 */       this.server_level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMember_count(int _v_)
/*      */     {
/* 1173 */       this.member_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/* 1180 */       this.win_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_times(int _v_)
/*      */     {
/* 1187 */       this.lose_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_member_count(int _v_)
/*      */     {
/* 1194 */       this.active_member_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1200 */       if (!(_o1_ instanceof Data)) return false;
/* 1201 */       Data _o_ = (Data)_o1_;
/* 1202 */       if (!this.name.equals(_o_.name)) return false;
/* 1203 */       if (this.level != _o_.level) return false;
/* 1204 */       if (this.server_level != _o_.server_level) return false;
/* 1205 */       if (this.member_count != _o_.member_count) return false;
/* 1206 */       if (this.win_times != _o_.win_times) return false;
/* 1207 */       if (this.lose_times != _o_.lose_times) return false;
/* 1208 */       if (this.active_member_count != _o_.active_member_count) return false;
/* 1209 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1215 */       int _h_ = 0;
/* 1216 */       _h_ += this.name.hashCode();
/* 1217 */       _h_ += this.level;
/* 1218 */       _h_ += this.server_level;
/* 1219 */       _h_ += this.member_count;
/* 1220 */       _h_ += this.win_times;
/* 1221 */       _h_ += this.lose_times;
/* 1222 */       _h_ += this.active_member_count;
/* 1223 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1229 */       StringBuilder _sb_ = new StringBuilder();
/* 1230 */       _sb_.append("(");
/* 1231 */       _sb_.append("'").append(this.name).append("'");
/* 1232 */       _sb_.append(",");
/* 1233 */       _sb_.append(this.level);
/* 1234 */       _sb_.append(",");
/* 1235 */       _sb_.append(this.server_level);
/* 1236 */       _sb_.append(",");
/* 1237 */       _sb_.append(this.member_count);
/* 1238 */       _sb_.append(",");
/* 1239 */       _sb_.append(this.win_times);
/* 1240 */       _sb_.append(",");
/* 1241 */       _sb_.append(this.lose_times);
/* 1242 */       _sb_.append(",");
/* 1243 */       _sb_.append(this.active_member_count);
/* 1244 */       _sb_.append(")");
/* 1245 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossCompeteMatchFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */